package nbody;

public class StaticBody extends Body {

	public StaticBody(Vec position, Vec velocity, double mass) {
		super(position, velocity, mass);
	}

	@Override
	public void move(Vec netForce) {
		// do nothing
	}
}
