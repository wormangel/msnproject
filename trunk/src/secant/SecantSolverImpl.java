package secant;

import java.util.ArrayList;
import java.util.List;

import misc.Function;

/**
 * 
 * @author Eugenia de Sousa
 * @author Jaluska Rodrigues
 * 
 */
public class SecantSolverImpl implements SecantSolver {
	public double epsilon = 0;
	public boolean iteration = false;
	
	public List<SecantResult> solve(Function funcion, double min, double max, double tolerance){
		
		return secant(funcion, min, max, tolerance, 0);
	}
	
	public List<SecantResult> solve(Function funcion, double min, double max, double tolerance, int maxIterations){
		iteration = true;
		return secant(funcion, min, max, tolerance, maxIterations);
	}

	public List<SecantResult> solve(Function funcion, double tolerance) {
		
		double x0 = Math.random();
		double x1 = Math.random();
		while(x1 == x0){
			x1= Math.random();
		}
		return secant(funcion, x0, x1, tolerance, 0);
	}
	
	private List<SecantResult> secant(Function function, double min, double max, double tolerance, int maxIterations){
		double x0 = min;
		double x1 = max;
		if(x1< x0){
			double oldx0 = x0;
			x0 = x1;
			x1 = oldx0;
		}
		double g = x1;
		boolean end = false;
		int k = 0;
		List<SecantResult> result = new ArrayList<SecantResult>();
		while(Math.abs(function.calculate(g))>tolerance && !end){
			k++;
		    
//			if(function.calculate(x0)*function.calculate(x1) > 0){
				g = calculate(x0, x1, function);
				result.add(new SecantResultImpl(x0,x1,g));
				x0 = escolheValor(function, x0,x1);
				x1 = g;
				if(x1<x0){
					double aux = x1;
					x1=x0;
					x0=aux;
				}
//			}
			if(k >= maxIterations && iteration){
				end = true;
			}
		
		}
		
		return result;
	}
	
	private double escolheValor(Function function, double x0, double x1) {
		if(Math.abs(function.calculate(x0))< Math.abs(function.calculate(x1))){
			return x0;
		}
		return x1;
	}

	private static double calculate(double x0, double x1, Function f){
		return (x0*f.calculate(x1)-x1*f.calculate(x0))/(f.calculate(x1)-f.calculate(x0));
	}

}