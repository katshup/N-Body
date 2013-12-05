package com.arshajii.nbody.backend;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// TEST
public class Main {
	public static void main(String[] args) throws IOException {
		Body sun = new StaticBody(new Vec(0, 0), Const.SOLAR_MASS);

<<<<<<< HEAD
		Body earth = new Body(new Vec(149600000000d, 0),
				new Vec(0, 30000d), 5.972E24);

		Body sun2 = new StaticBody(new Vec(0, -149600000000d * 2), new Vec(
				0, 0), Const.SOLAR_MASS);
=======
		Body earth = new Body(new Vec(149600000000d, 0), new Vec(0, 30000d),
				5.972E24);

		Body sun2 = new StaticBody(new Vec(0, -149600000000d * 2),
				Const.SOLAR_MASS);
>>>>>>> origin/master

		Universe u = new Universe(new Body[] { sun, sun2, earth });

		PrintWriter w = new PrintWriter(new FileWriter("results.txt"));

		for (int i = 0; i < 365 * 2; i++) {
			u.print(w);
			u.step();
		}

		w.close();
	}
}
