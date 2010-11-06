package br.edu.ufcg.msnlab.methods.laguerre;

import java.util.LinkedList;
import java.util.List;

import br.edu.ufcg.msnlab.misc.Function;
import br.edu.ufcg.msnlab.misc.PolynomialParser;

import mfc.field.Complex;


/**
 * Laguerre Method Solver
 * 
 * @author Marcus Williams
 * @author Carla Araujo
 *
 */
public class LaguerreSolverImpl implements LaguerreSolver {

	public static final int DEFAULT_MAX_ITERATIONS = 100;
	public static final double DEFAULT_GUESS = 0;

	public List<LaguerreResult> solve(Function function, double guess,
			double tolerance) {

		return solve(function,guess,tolerance,DEFAULT_MAX_ITERATIONS);
	}

	public List<LaguerreResult> solve(Function f, double guess,
			double tolerance, int maxIterations) {

		List<LaguerreResult> results = new LinkedList<LaguerreResult>();

		Function fd1 = f.derivative();
		Function fd2 = fd1.derivative();
		int n = PolynomialParser.polynomialDegree(f.getExpression());

		Complex one = new Complex(1);
		int iterations = 1;
		Complex x = new Complex(guess);
		Complex fres = f.calculate(x);
		Complex a = fres;

		if (Math.abs(a.re) <= tolerance) {
			results.add(new LaguerreResultImpl(guess,x));
		} else {

			while (iterations <= maxIterations && a.abs() > tolerance && fres.abs() > tolerance) {
				fres = f.calculate(x);
				Complex fd1res = fd1.calculate(x);
				Complex fd2res = fd2.calculate(x);
				Complex g = fd1res.divide(fres);
				Complex h = g.pow(2).minus(fd2res.divide(fres));
				Complex sqrt = h.times(n).minus(g.pow(2)).times(n-1).sqrt();
				Complex den1 = g.plus( sqrt );
				Complex den2 = g.minus( sqrt );
				Complex den = den1.abs() > den2.abs() ? den1 : den2;
				
				results.add(new LaguerreResultImpl(guess,x));
				a = one.times(n).divide(den);
				x = x.minus(a);
				iterations++;
			}
		}
		return results;
	}

	public List<LaguerreResult> solve(Function function, double tolerance) {
		return solve(function, DEFAULT_GUESS, tolerance);
	}

}
