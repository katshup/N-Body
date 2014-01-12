package com.arshajii.nbody.backend;

public class StaticBody extends Body {

	public StaticBody(Vec position, double mass, float SCALE, float R, float G, float B) {
		super(position, new Vec(0, 0), mass, SCALE, R, G, B);
	}

	@Override
	public void move(Vec netForce) {
		// do nothing
	}
}
