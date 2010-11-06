/**
 * 
 */
package misc;

import java.util.List;

import mfc.field.Complex;

public interface Function {
	public String getExpression();
	public double calculate(double value);
	public Complex calculate(Complex value);
	public Function derivative();
	public List<Point> getPoints();
	public List<Point> getPoints(double min, double max, double step);
}
