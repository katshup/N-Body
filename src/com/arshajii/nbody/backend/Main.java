package com.arshajii.nbody.backend;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		Body sun = new StaticBody(new Vec(0, 0), new Vec(0, 0),
				Const.SOLAR_MASS);

		Body earth = new Body(new Vec(149_600_000_000d, 0), new Vec(0,
				30_000d / 3), 5.972E24);

		Body sun2 = new StaticBody(new Vec(0, -149_600_000_000d * 2), new Vec(
				0, 0), Const.SOLAR_MASS);

		Universe u = new Universe(new Body[] { sun, sun2, earth });

		PrintWriter w = new PrintWriter(new FileWriter("results.txt"));

		for (int i = 0; i < 365 * 2; i++) {
			u.print(w);
			u.step();
		}

		w.close();
	}
}
