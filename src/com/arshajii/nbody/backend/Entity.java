package com.arshajii.nbody.backend;

public abstract class Entity {

	// position vector in m:
	private Vec pos;

	public void setPos(Vec pos) {
		this.pos = pos;
	}

	public Entity(Vec position) {
		this.pos = position;
	}

	protected Vec getPos() {
		return pos;
	}
}
