package newtonRaphson;


/** 
 * 
 * @author Alvaro Magnum
 * @author Marcus Leite
 *
 */
public class NewtonRaphsonResultImpl implements NewtonRaphsonResult{
	
	private double x;

	/**
	 * Constructor.
	 * @param x
	 */
	public NewtonRaphsonResultImpl(double x) {
		this.x = x;
	}
	
	/**
	 * Return x.
	 */
	public double getX() {
		return x;
	}


}