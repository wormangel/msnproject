package br.edu.ufcg.msnlab.methods.fixedpoint;


/** 
 * 
 * @author Alvaro Magnum
 * @author Marcus Leite
 *
 */
public class FixedPointResultImpl implements FixedPointResult {
	
	private double x;
	private double iteration;

	/**
	 * Get x.
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Set x.
	 * @param x
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * Get iteration.
	 * @return Iteration.
	 */
	public double getIteration() {
		return iteration;
	}
	
	/**
	 * Set iteration.
	 * @param iteration
	 */
	public void setIteration(double iteration) {
		this.iteration = iteration;
	}
	
}