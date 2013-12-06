package com.ccpa.n_body;

import javax.microedition.khronos.opengles.GL10;

import com.arshajii.nbody.backend.Body;
import com.arshajii.nbody.backend.Universe;
import com.arshajii.nbody.backend.Vec;

public class BodyRendering {

	private static final double DEFAULT_MASS = 100;

	private final Body data;
	private final Circle image;

	public BodyRendering(Universe universe, double x, double y) {
		data = new Body(new Vec(x, y), new Vec(0, 0), DEFAULT_MASS);
		universe.addBody(data);

		image = new Circle((float) data.getPos().getX(), (float) data.getPos()
				.getY());
	}

	public void draw(GL10 gl) {
		image.setXY((float) data.getPos().getX(), (float) data.getPos().getY());
		image.draw(gl);
	}

}
