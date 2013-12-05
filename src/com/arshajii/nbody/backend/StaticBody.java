package com.arshajii.nbody.backend;

public class StaticBody extends Body {

	public StaticBody(Vec position, double mass) {
		super(position, new Vec(0, 0), mass);
	}

	@Override
	public void move(Vec netForce) {
		// do nothing
	}
}
