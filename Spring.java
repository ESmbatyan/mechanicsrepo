
public class Spring {
	double k;
	double[] array;
	double w;

	public Spring() {
		k = 1;
	}

	public Spring(double stiffness) {
		k = stiffness;
	}

	public double GetStiffness() {
		return k;
	}

	public double SetStiffness() {
		return k;
	}

	public double omegaCalc(double k, double m) {
		return w = Math.sqrt(k / m);
	}

	private double[] moveEquation(double t0, double t, double dt, double x0, double v0, double m) {

		double[] temp = new double[(int) Math.ceil((t - t0) / dt)];
		for (int i = 0; i < (Math.ceil(t - t0) / dt); i++) {
			double val = x0 * Math.cos(omegaCalc(k, m) * (i * dt))
					+ (v0 / omegaCalc(k, m)) * Math.sin(omegaCalc(k, m) * (i * dt));
			array[i] = val;
		}
		return array;

	}

	public double[] move(double t, double dt, double x0, double v0) {

		return moveEquation(0, t, dt, x0, v0, 1);
	}

	double[] move(double t, double dt, double x0) {

		return moveEquation(0, t, dt, x0, 0, 1);
	}

	double[] move(double t0, double t1, double dt, double x0, double v0) {

		return moveEquation(t0, t1, dt, x0, v0, 1);
	}

	double[] move(double t0, double t1, double dt, double x0, double v0, double m) {

		return moveEquation(t0, t1, dt, x0, v0, m);
	}

	public Spring inSeries(Spring that) {
		double newK = (this.k * that.k) / (this.k + that.k);
		Spring newOne = new Spring(newK);
		return newOne;

	}

	public Spring inParallel(Spring that) {
		double newK = (this.k + that.k);
		Spring newOne = new Spring(newK);
		return newOne;

	}

}
