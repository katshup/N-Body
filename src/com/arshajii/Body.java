package nbody;

public class Body extends Entity {

	// velocity vector in m/s:
	private Vec velocity;

	// mass in kg:
	private double mass;

	public Body(Vec position, Vec velocity, double mass) {
		super(position);
		this.velocity = velocity;
		this.mass = mass;
	}

	public Vec getVelocity() {
		return velocity;
	}

	public double getMass() {
		return mass;
	}

	public Vec forceFrom(Body other) {
		Vec v = other.getPos().sub(getPos());
		double r = v.mag();
		return v.toUnitVector().mul(
				Const.G * mass * other.mass / (r * r + Const.EPS * Const.EPS));
	}

	public void move(Vec netForce) {
		// update velocity according to net force:
		velocity = velocity.add(netForce.mul(Const.dT / mass));

		// update position according to new velocity:
		setPos(getPos().add(velocity.mul(Const.dT)));
	}
}
