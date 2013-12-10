package com.arshajii.nbody.backend;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import android.util.Log;

public class Universe {
	private final List<Body> bodies = Collections
			.synchronizedList(new ArrayList<Body>());

	private int time = 0;
	
	public static double gravConst = Const.G;

	boolean walled = false;
	private double xWallUp, xWallDown;
	private double yWallUp, yWallDown;

	public Universe() {

	}

	public Universe(Collection<Body> bodies) {
		this.bodies.addAll(bodies);
	}

	public Universe(Body[] bodies) {
		this.bodies.addAll(Arrays.asList(bodies));
	}

	public void addBody(Body body) {
		bodies.add(body);
	}
	
	public void removeBody() {
		Log.d("attempt to remove",String.valueOf(this.bodies.size()));
		bodies.remove(bodies.size() - 1);
		Log.d("removed",String.valueOf(this.bodies.size()));
	}

	public void step() {
		synchronized (bodies) {
			for (Body body1 : bodies) {
				MutableVec netForce = new MutableVec(0, 0);

				for (Body body2 : bodies) {
					if (body1 != body2) {
						netForce.inPlaceAdd(body1.forceFrom(body2));
					}
				}

				body1.move(netForce);

				if (walled) {
					Vec pos = body1.getPos();

					if (pos.getX() >= xWallUp || pos.getX() <= xWallDown) {
						body1.reverseVx();
					}

					if (pos.getY() >= yWallUp || pos.getY() <= yWallDown) {
						body1.reverseVy();
					}
				}
			}
		}

		time++;
	}

	public void clear() {
		bodies.clear();
	}

	public void moveAll(Vec delta) {
		synchronized (bodies) {
			for (Body body : bodies)
				body.moveDirect(delta);
		}
	}

	public void addWalls(double xWallUp, double xWallDown, double yWallUp,
			double yWallDown) {

		this.xWallUp = xWallUp;
		this.xWallDown = xWallDown;
		this.yWallUp = yWallUp;
		this.yWallDown = yWallDown;

		walled = true;
	}

	public void print(Writer w) {
		try {
			w.write(Integer.toString(time));
			w.write('\t');

			for (Body body : bodies) {
				w.write(Double.toString(body.getPos().getX()));
				w.write('\t');
				w.write(Double.toString(body.getPos().getY()));
				w.write('\t');
			}

			w.write('\n');
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void print() {
		System.out.print(time);
		System.out.print('\t');

		for (Body body : bodies) {
			System.out.print(body.getPos().getX());
			System.out.print('\t');
			System.out.print(body.getPos().getY());
			System.out.print('\t');
		}

		System.out.println();
	}
}
