package com.ccpa.n_body;

import javax.microedition.khronos.opengles.GL10;

import com.arshajii.nbody.backend.Body;
import com.arshajii.nbody.backend.Universe;
import com.arshajii.nbody.backend.Vec;

public class BodyRendering {

	

	private final Body data;
	private final Circle image;

	public BodyRendering(Universe universe, double x, double y, float SCALE, float R, float G, float B) {
		data = new Body(new Vec(x, y), new Vec(0, 0), SCALE*100);
		universe.addBody(data);

		image = new Circle((float) data.getPos().getX(), (float) data.getPos()
				.getY(), SCALE, R, G, B);
	}

	public void draw(GL10 gl) {
		image.setXY((float) data.getPos().getX(), (float) data.getPos().getY());
		image.draw(gl);
	}

}
