/**
 * 
 */
package br.edu.ufcg.msnlab.misc;

import java.util.List;

import mfc.field.Complex;

/**
 * @author Rodrigo
 *
 */
public interface Function {
	
	/**
	 * TODO
	 * @return
	 */
	public String getExpression();
	
	/**
	 * TODO
	 * @param value
	 * @return
	 */
	public double calculate(double value);
	
	/**
	 * TODO
	 * @param value
	 * @return
	 */
	public Complex calculate(Complex value);
	
	/**
	 * TODO
	 * @return
	 */
	public Function derivative();

	/**
	 * TODO
	 * @return
	 */
	public List<Point> getPoints();
	
	/**
	 * TODO
	 * @param min
	 * @param max
	 * @param step
	 * @return
	 */
	public List<Point> getPoints(double min, double max, double step);

}
