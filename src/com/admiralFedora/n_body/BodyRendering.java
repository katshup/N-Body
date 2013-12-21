package com.admiralFedora.n_body;

import javax.microedition.khronos.opengles.GL10;

import android.util.Log;

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
		data = new Body(new Vec(x, y), new Vec(0, 0), SCALE*globalVar.massSCALE); 
		universe.addBody(data);
		image = new Circle((float)data.getPos().getX()*globalVar.distSCALEDOWN, (float)(data.getPos().getY()*globalVar.distSCALEDOWN), SCALE, R, G, B); 
	}
	
	public BodyRendering(Universe universe, double x, double y, float xVel, float yVel, float SCALE, float R, float G, float B)
	{
		Log.d("velocity",String.valueOf(xVel));
		data = new Body(new Vec(x, y), new Vec(xVel, yVel), SCALE*globalVar.massSCALE); 
		universe.addBody(data);
		image = new Circle((float)(data.getPos().getX()*globalVar.distSCALEDOWN), (float)(data.getPos().getY()*globalVar.distSCALEDOWN), SCALE, R, G, B); 
	}
	
	public BodyRendering(Universe universe, double x, double y, float SCALE, float R, float G, float B, boolean isStatic)
	{ 
		data = new StaticBody(new Vec(x, y), SCALE*2*globalVar.massSCALE); 
		universe.addBody(data);
		image = new Circle((float)(data.getPos().getX()*globalVar.distSCALEDOWN), (float)(data.getPos().getY()*globalVar.distSCALEDOWN), SCALE, R, G, B); 
	}
	

	/*public BodyRendering(Universe universe, double xPos, double yPos,
			double xVel, double yVel) {

		data = new Body(new Vec(xPos, yPos), new Vec(xVel, yVel), DEFAULT_MASS);
		universe.addBody(data);

		image = new Circle((float) data.getPos().getX(), (float) data.getPos()
				.getY());*
	}*/

	public void draw(GL10 gl) {
		image.setXY((float)(data.getPos().getX()*globalVar.distSCALEDOWN), (float)(data.getPos().getY()*globalVar.distSCALEDOWN));
		image.draw(gl);
	}
	

}
