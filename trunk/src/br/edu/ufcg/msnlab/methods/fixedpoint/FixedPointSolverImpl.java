package br.edu.ufcg.msnlab.methods.fixedpoint;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.msnlab.misc.Function;

/**
 * @author Alvaro Magnum
 * @author Marcus Leite
 */
public class FixedPointSolverImpl implements FixedPointSolver {

    private double maxIters;
    private double tolerance = 0;
    private double xn = Float.NaN;
    private double prevXn, gn;
    private Function function;
    private int n;

    /**
     * Constructor.
     * @param function
     */
    public FixedPointSolverImpl(Function function) {}

    /**
     * Reset the n and gn parameters.
     * @param x0 x0
     */
    public void reset(double x0) {
        n = 0;
        gn = x0;
    }

    /**
     * Get xn
     * @return xn
     */
    public double getXn() {
        return xn;
    }

    /**
     * Get gn
     * @return gn
     */
    public double getGn() {
        return gn;
    }
    
    /**
     * Do the step of Fixed-Point Method.
     * @return True if has converged, false otherwise.
     * @throws Exception
     */
    public boolean step(Function itFunction) throws Exception {
        checkIterationCount();
        computeNextPosition(itFunction);
        checkPosition();
        return hasConverged();
    }
    
    /**
     * Check if the method reached the maximum number of iterations.
     * @throws Exception If reached the maximum number of iterations.
     */
    public void checkIterationCount() throws Exception {
        if (++n > maxIters) {
        	throw new Exception();
        }
    }

    /**
     * Compute the next position.
     */
    public void computeNextPosition(Function itFunction) {
    	if (itFunction != null) {
    		prevXn = itFunction.calculate(xn);
    	} else prevXn = xn;
        xn = gn;
        gn = function.calculate(xn);
    }

    /**
     * Check if is a valid position.
     * @throws Exception If isn´t a valid position.
     */
    public void checkPosition() throws Exception {
        if (xn == prevXn) {
        	throw new Exception();
        }
    }

    /**
     * Verifies if has converged.
     * @return True if has converged, false otherwise.
     */
    public boolean hasConverged() {
        return Math.abs((gn - xn) / xn) < tolerance;
    }
    
    /**
     * Get the number of iterations.
     * @return Number of iterations.
     */
    public double getIterationCount() {
    	return n;
    }

	/**
	 * Solve with the function, initial guess, tolerance and maximum number of iterations.
	 */
    public List<FixedPointResult> solve(Function function, Function itFunction, double guess, double tolerance, double maxIteration) throws Exception {
		List<FixedPointResult> list = new ArrayList<FixedPointResult>();
        try {
        	this.reset(guess);
        	this.tolerance = tolerance;
        	this.maxIters = maxIteration;
        	this.function = function;
            boolean converged;
        	do {
        		converged = this.step(itFunction);
        		FixedPointResultImpl fixedPointResult = new FixedPointResultImpl();
        		fixedPointResult.setIteration(this.getIterationCount());
        		fixedPointResult.setX(xn);
        		list.add(fixedPointResult);
        	} while (!converged);
        	return list;
        } catch (Exception e) {}
    	return list;
    }

	/**
	 * Solve with the function and tolerance.
	 */
    public List<FixedPointResult> solve(Function funcion, double tolerance) {
		try {
			return solve(funcion, null, 1, tolerance, 3000);
		} catch (Exception e) {}
		return null;
	}

	/**
	 * Solve with the function, the initial guess and tolerance.
	 */
    public List<FixedPointResult> solve(Function function, Function itFunction, double guess, double tolerance) throws Exception {
		return solve(function, itFunction, guess, tolerance, 3000);
	}

}