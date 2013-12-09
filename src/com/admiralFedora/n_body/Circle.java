package com.admiralFedora.n_body;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Circle {

	private int points = 360;
	public float vertices[] = { 0.0f, 0.0f, 0.0f };
	private FloatBuffer vertBuff;
	private float x, y;
	private float R,G,B;

	public Circle(float x, float y, float SCALE, float R, float G, float B) {
		this.x = x;
		this.y = y;
		this.R = R;
		this.G = G;
		this.B = B;
		vertices = new float[(points + 1) * 3];

		for (int i = 3; i < (points + 1) * 3; i += 3) {
			double rad = (i * 360 / points * 3) * (3.14 / 180);
			vertices[i] = SCALE * (float) Math.cos(rad);
			vertices[i + 1] = SCALE * (float) Math.sin(rad);
			vertices[i + 2] = 0;
		}

		ByteBuffer bBuff = ByteBuffer.allocateDirect(vertices.length * 4);
		bBuff.order(ByteOrder.nativeOrder());
		vertBuff = bBuff.asFloatBuffer();
		vertBuff.put(vertices);
		vertBuff.position(0);

	}

	public void draw(GL10 gl) {
		gl.glPushMatrix();
		gl.glTranslatef(x, y, 0);
		gl.glColor4f(R, G, B, 1.0f);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertBuff);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, points / 2);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glPopMatrix();
	}

	public void setXY(float x, float y) {
		this.x = x;
		this.y = y;
	}
}
