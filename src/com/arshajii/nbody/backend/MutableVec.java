package com.arshajii.nbody.backend;

public class MutableVec extends Vec {

	public MutableVec(double x, double y) {
		super(x, y);
	}

	public void inPlaceAdd(Vec other) {
		x += other.x;
		y += other.y;
	}
}
