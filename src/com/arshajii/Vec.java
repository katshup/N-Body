package nbody;

public class Vec {
	private double x, y;

	public Vec(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public Vec add(Vec other) {
		return new Vec(x + other.x, y + other.y);
	}

	public Vec sub(Vec other) {
		return new Vec(x - other.x, y - other.y);
	}

	public Vec mul(double scalar) {
		return new Vec(x * scalar, y * scalar);
	}

	public Vec div(double scalar) {
		return new Vec(x / scalar, y / scalar);
	}

	public double dot(Vec other) {
		return x * other.x + y * other.y;
	}

	public double cross(Vec other) {
		return x * other.y - y * other.x;
	}

	public double dist(Vec other) {
		return Math.hypot(x - other.x, y - other.y);
	}

	public double mag() {
		return Math.hypot(x, y);
	}

	public Vec toUnitVector() {
		return div(mag());
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
