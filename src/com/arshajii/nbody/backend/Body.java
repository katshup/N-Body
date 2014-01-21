package com.arshajii.nbody.backend;

import javax.microedition.khronos.opengles.GL10;

import android.R.string;
import android.util.Log;
import com.admiralFedora.n_body.Circle;
import com.admiralFedora.n_body.globalVar;

public class Body extends Entity {

	// velocity vector in m/s:
	private Vec velocity;

	// mass in kg:
	private double mass;

	// image
	private Circle image;

	// size
	public float size;

	// static body
	private boolean isStatic;

	public Body(Vec position, Vec velocity, double mass, float SCALE, float R,
			float G, float B, boolean isStatic) {
		super(position);
		this.velocity = velocity;
		this.mass = mass;
		size = SCALE;
		this.isStatic = isStatic;
		image = new Circle((float) position.getX() * globalVar.distSCALEDOWN,
				(float) (position.getY() * globalVar.distSCALEDOWN), SCALE, R,
				G, B);
	}

	public Vec getVelocity() {
		return velocity;
	}

	public double getMass() {
		return mass;
	}

	public Vec forceFrom(Body other) {
		Vec v = other.getPos().sub(getPos());
		double r = v.mag();
		// Log.d("radius",String.valueOf(r*globalVar.distSCALEDOWN));
		return v.toUnitVector()
				.mul(Const.G * mass * other.mass
						/ (r * r + Const.SOFT * Const.SOFT));
	}

	public double distance(Body other) {
		Vec v = other.getPos().sub(getPos());
		return v.mag();
	}

	public void absorption(Body absorpee) {
		float sizeDiff = absorpee.size / size;
		float R = (image.R + (absorpee.image.R * sizeDiff)) / 2;
		float G = (image.G + (absorpee.image.G * sizeDiff)) / 2;
		float B = (image.B + (absorpee.image.B * sizeDiff)) / 2;
		mass = (mass + absorpee.mass * sizeDiff);
		if (size > absorpee.size) {
			size = (float) ((size + (absorpee.size * .4)));
		} else {
			size = (float) ((size * .4) + absorpee.size);
		}
		velocity = new Vec(velocity.getX() * .4, velocity.getY() * .4);
		// setPos(absorpee.getPos());
		image = new Circle((float) getPos().getX(), (float) getPos().getY(),
				size, R, G, B);
		if (this.isStatic || absorpee.isStatic) {
			this.isStatic = true;
		}
		// return new Body(getPos(),getVelocity(), mass+absorpee.mass,
		// size+absorpee.size, R, G, B);
	}

	public void refactor(float massCHNG, float distCHNG, float velCHNG) {
		this.setPos(new Vec(getPos().getX() * distCHNG, getPos().getY() * distCHNG));
		this.mass = this.mass * massCHNG;
		this.velocity = new Vec(velocity.x * velCHNG, velocity.y * velCHNG);
		image = new Circle((float) getPos().getX(), (float) getPos().getY(),
				size, image.R, image.G, image.B);
	}

	public void move(Vec netForce) {
		if (!isStatic) {
			// update velocity according to net force:
			velocity = velocity.add(netForce.mul(Const.dT / mass));

			// update position according to new velocity:
			setPos(getPos().add(velocity.mul(Const.dT)));
		} else {
			// do nothing
		}
	}

	public void moveDirect(Vec delta) {
		setPos(getPos().add(delta));
	}

	public void reverseVx() {
		velocity = new Vec(-.8 * velocity.getX(), .8 * velocity.getY());
	}

	public void reverseVy() {
		velocity = new Vec(.8 * velocity.getX(), -.8 * velocity.getY());
	}

	public void draw(GL10 gl) {
		image.setXY((float) (this.getPos().getX() * globalVar.distSCALEDOWN),
				(float) (this.getPos().getY() * globalVar.distSCALEDOWN));
		image.draw(gl);
	}
}
