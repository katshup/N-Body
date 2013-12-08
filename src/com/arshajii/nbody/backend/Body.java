package com.arshajii.nbody.backend;

public class Body extends Entity {

	// velocity vector in m/s:
	private Vec velocity;

	// mass in kg:
	private double mass;

	public Body(Vec position, Vec velocity, double mass) {
		super(position);
		this.velocity = velocity;
		this.mass = mass;
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
		return v.toUnitVector()
				.mul(Universe.gravConst * mass * other.mass
						/ (r * r + Const.SOFT * Const.SOFT));
	}

	public void move(Vec netForce) {
		// update velocity according to net force:
		velocity = velocity.add(netForce.mul(Const.dT / mass));

		// update position according to new velocity:
		setPos(getPos().add(velocity.mul(Const.dT)));
	}

	public void moveDirect(Vec delta) {
		setPos(getPos().add(delta));
	}

	public void reverseVx() {
		velocity = new Vec(-.75*velocity.getX(), .75*velocity.getY());
	}

	public void reverseVy() {
		velocity = new Vec(.75*velocity.getX(), -.75*velocity.getY());
	}
}
