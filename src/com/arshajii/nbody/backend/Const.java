package com.arshajii.nbody.backend;

public class Const {
	// gravitational constant (units: m^3 kg^-1 s^-2)
	public static double G = 6.67384E-9; // norm: 6.67384E-11

	// time delta (units: s)
	public static double dT = 86400; //21600; // 6 hours instead of 24 hours

	// solar mass (units: kg)
	public static final double SOLAR_MASS = 1.989E30;

	// gravity softening factor (units: m)
	public static double SOFT =  3E3; //1; //1E6;
}
