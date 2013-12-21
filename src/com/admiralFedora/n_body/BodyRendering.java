package com.admiralFedora.n_body;

import javax.microedition.khronos.opengles.GL10;

import com.arshajii.nbody.backend.Body;
import com.arshajii.nbody.backend.StaticBody;
import com.arshajii.nbody.backend.Universe;
import com.arshajii.nbody.backend.Vec;

public class BodyRendering {

	//private static final double DEFAULT_MASS = 100;

	private final Body data;
	private final Circle image;

	public BodyRendering(Universe universe, double x, double y, float SCALE, float R, float G, float B)
	{ 
		data = new Body(new Vec(x, y), new Vec(0, 0), SCALE*100); 
		universe.addBody(data);
		image = new Circle((float)(data.getPos().getX()*Math.pow(10,-6)), (float)(data.getPos().getY()*Math.pow(10,-6)), SCALE, R, G, B); 
	}
	
	public BodyRendering(Universe universe, double x, double y, float xVel, float yVel, float SCALE, float R, float G, float B)
	{ 
		data = new Body(new Vec(x, y), new Vec(xVel, yVel), SCALE*100); 
		universe.addBody(data);
		image = new Circle((float)(data.getPos().getX()*Math.pow(10,-6)), (float)(data.getPos().getY()*Math.pow(10,-6)), SCALE, R, G, B); 
	}
	
	public BodyRendering(Universe universe, double x, double y, float SCALE, float R, float G, float B, boolean isStatic)
	{ 
		data = new StaticBody(new Vec(x, y), SCALE*200); 
		universe.addBody(data);
		image = new Circle((float)(data.getPos().getX()*Math.pow(10,-6)), (float)(data.getPos().getY()*Math.pow(10,-6)), SCALE, R, G, B); 
	}
	

	/*public BodyRendering(Universe universe, double xPos, double yPos,
			double xVel, double yVel) {

		data = new Body(new Vec(xPos, yPos), new Vec(xVel, yVel), DEFAULT_MASS);
		universe.addBody(data);

		image = new Circle((float) data.getPos().getX(), (float) data.getPos()
				.getY());*
	}*/

	public void draw(GL10 gl) {
		image.setXY((float)(data.getPos().getX()*Math.pow(10,-6)), (float)(data.getPos().getY()*Math.pow(10,-6)));
		image.draw(gl);
	}
	

}
