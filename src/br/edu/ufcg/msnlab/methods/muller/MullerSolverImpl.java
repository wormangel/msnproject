package br.edu.ufcg.msnlab.methods.muller;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.msnlab.misc.Function;

/**
 * 
 * @author Eugenia de Sousa
 * @author Jaluska Rodrigues
 * 
 */
public class MullerSolverImpl implements MullerSolver {

	public boolean iteration = false;
	public List<MullerResult> solve(Function funcion, double x0, double x1,
			double x2, double tolerance) {
		
		return muller(funcion, x0, x1, x2, tolerance, 0);
	}

	public List<MullerResult> solve(Function funcion, double x0, double x1,
			double x2, double tolerance, int maxIterations) {
		iteration = true;
		return muller(funcion, x0, x1, x2, tolerance, maxIterations);
	}

	public List<MullerResult> solve(Function funcion, double tolerance) {
		// TODO Auto-generated method stub
		double x0 = Math.random();
		double x1 = Math.random();
		while(x1 == x0){
			x1= Math.random();
		}
		double x2 = Math.random();
		while(x2 == x1 || x2 ==x0){
			x2= Math.random();
		}
		
		return muller(funcion, x0, x1, x2, tolerance, 0);
	}
	
	
	public List<MullerResult> muller(Function funcion, double x0, double x1,
			double x2, double tolerance, int maxIterations){
		double min = min(x0, x1, x2);
		double min2 =min2(x0, x1, x2, min);
		double min3 =min3(x0, x1, x2, min, min2);
		x0=min3;
		x1=min2;
		x2=min;
		boolean end = false;
		int k = 0;
		double x3 = x2;
//		double fx3;
		List<MullerResult> result = new ArrayList<MullerResult>();
		while(Math.abs(funcion.calculate(x2))>tolerance && !end){
			k++;
		    
			x3 = rootCalculate(funcion, x0, x1, x2);
//			fx3 =functionCalculate(funcion, x0, x1, x2, x3);
			result.add(new MullerResultImpl(x0,x1,x2,x3));
			x0=x1;
			x1=x2;
			x2=x3;
			
			
			if(k >= maxIterations && iteration){
				end = true;
			}
		
		}
		
		return result;
		
		
		
	}
	public static double min3(double a, double b, double c, double min, double min2){
		if(a!=min && a!=min2){
			return a;
		}else if(b!=min && b!=min2){
			return b;
		}
		return c;
	}
	
	public static double min2(double a, double b, double c, double min){
		if(a==min){
			return Math.min(b, c);
		}else if(b==min){
			return Math.min(a,c);
		}
		return Math.min(a, b);
	}
	
	public static double min(double a, double b, double c){
		double min = Math.min(a, b);
		return Math.min(min, c);
	}
	
	public double functionCalculate(Function funcion, double x0, double x1,
			double x2, double xi){
		double a = aCalculate(funcion, x0, x1, x2);
		double b = bCalculate(funcion, x0, x1, x2);
		double c = cCalculate(funcion, x2);
		return a*(xi-x2)*(xi-x2) + b*(xi-x2) +c;
	}
	public double rootCalculate(Function funcion, double x0, double x1,
			double x2){
		double a = aCalculate(funcion, x0, x1, x2);
		double b = bCalculate(funcion, x0, x1, x2);
		double c = cCalculate(funcion, x2);
		if(b>=0){
			return x2+(-2*c)/(b+Math.sqrt(b*b-4*a*c));	
		}
		return x2+(-2*c)/(b-Math.sqrt(b*b-4*a*c));	
	}
	
	public double aCalculate(Function funcion, double x0, double x1,
			double x2){
						
		return (omegaCalculate(funcion, x0, x1, x2, 1)- omegaCalculate(funcion, x0, x1, x2, 0))/(hCalculate(x0, x1, x2, 1)+hCalculate(x0, x1, x2, 2));
	}
	
	public double bCalculate(Function funcion, double x0, double x1,
			double x2){
		return aCalculate(funcion, x0, x1, x2)*hCalculate(x0, x1, x2, 1)+omegaCalculate(funcion, x0, x1, x2, 1);
	}
	
	public double cCalculate(Function funcion, double x2){
		return funcion.calculate(x2);
	}
	
	public double omegaCalculate(Function funcion, double x0, double x1,
			double x2, int i){
		if(i==0){
			return (funcion.calculate(x1) - funcion.calculate(x0))/(x1-x0);
		}
		return (funcion.calculate(x2) - funcion.calculate(x1))/(x2-x1);
	}
	
	public double hCalculate(double x0, double x1,
			double x2, int i){
		if(i==2){
			return x2-x1;
		}
		return x1-x0;
	}

}
