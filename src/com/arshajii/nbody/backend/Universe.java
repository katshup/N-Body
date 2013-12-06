package com.arshajii.nbody.backend;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Universe {
	private final Collection<Body> bodies = Collections
			.synchronizedList(new ArrayList<Body>());

	private int time = 0;

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
			}
		}

		time++;
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
