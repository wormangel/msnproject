package misc;

public class PointImpl implements Point {
	
	private double x;
	private double y;

	public PointImpl(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/* (non-Javadoc)
	 * @see misc.Point#getX()
	 */
	public double getX() {
		return this.x;
	}

	/* (non-Javadoc)
	 * @see misc.Point#getY()
	 */
	public double getY() {
		return this.y;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Point o) {
		Double _x = new Double(x);
		Double _ox = new Double(o.getX());
		
		Double _y = new Double(y);
		Double _oy = new Double(o.getY());
		
		if (_x.compareTo(_ox) == 0)
			return _y.compareTo(_oy);
		return _x.compareTo(_ox);
	}
}
