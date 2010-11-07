package br.edu.ufcg.msnlab.methods.petkovic;

import java.util.*;

import mfc.field.Complex;

import br.edu.ufcg.msnlab.misc.Function;

/**
 * @author Otacilio Freitas de Lacerda
 * @author Lucas Medeiros de Azevedo.
 */
public class PetkovicSolverImpl implements PetkovicSolver {
	
	private Complex root = new Complex(Double.NaN);
    private double tolerance = 0;
    private double maxIterations = 3000;
	
	/**
	 * This method do the Petkovic.
	 * @param g The function.
	 * @param guess The initial guess.
	 * @param tolerance The tolerance.
	 * @param maxIterations Maximum numbers of iterations.
	 * @return A list with the results of each iteration.
	 * @throws Exception 
	 */
    public List<PetkovicResult> petkovic(Function g, double guess, double tolerance, double maxIterations) throws Exception{
		
        boolean testConv = true;
        double iterN = 0;
        
        Complex diff = new Complex(1e300);        
        Complex complexGuess = new Complex(guess);
        
	    Complex[] f = {g.calculate(complexGuess), g.derivative().calculate(complexGuess)};
	    this.tolerance = tolerance;
	    this.maxIterations = maxIterations;
	    List<PetkovicResult> results = new ArrayList<PetkovicResult>();

	    if(isNaN(f[0]) || isNaN(f[1])){
	    	results.add(new PetkovicResultImpl(new Complex(Double.NaN)));
	    }
        while(testConv){
            diff = f[0].divide(f[1]);
            results.add(new PetkovicResultImpl(f[0]));
            if(f[0].equals(0.0D) || diff.abs()<this.tolerance){
                this.root = complexGuess;
                results.add(new PetkovicResultImpl(this.root));
                testConv=false;
            }
            else{
            	Complex fDeXmenosDerivada = g.calculate(complexGuess.minus(diff));
            	Complex valorDentroRaiz = new Complex(1).minus( fDeXmenosDerivada.times(4).divide(f[0]) );
            	
            	Complex numerator = diff.times(2);
            	Complex valorDaRaiz;
            	
            	valorDaRaiz = valorDentroRaiz.sqrt();
            	
            	Complex  denominator = new Complex(1).minus(valorDaRaiz).abs() > new Complex(1).plus(valorDaRaiz).abs() ? new Complex(1).minus(valorDaRaiz) : new Complex(1).plus(valorDaRaiz);
            	
                complexGuess = complexGuess.minus(numerator.divide(denominator));
                
                f[0] = g.calculate(complexGuess);
                f[1] = g.derivative().calculate(complexGuess);
	            if(isNaN(f[0]) || isNaN(f[1])){
	            	results.add(new PetkovicResultImpl(new Complex(Double.NaN)));
	            }
            }
            iterN++;
            if(iterN>this.maxIterations){
                this.root = complexGuess;
                results.add(new PetkovicResultImpl(this.root));
                testConv = false;
            }
        }
        return results;
    }
	
	private boolean isNaN(Complex complex) {
		return complex.isNaN();
	}

	/**
	 * Verify if a double is a NaN.
	 * @param x The double to be verified.
	 * @return True if is NaN, false otherwise.
	 */
    private boolean isNaN(double x){
        boolean test=false;
        if(x!=x)test=true;
        return test;
    }

	/**
	 * Solve with the function, guess and tolerance.
	 */
    public List<PetkovicResult> solve(Function function, double guess, double tolerance) throws Exception {
		return petkovic(function, guess, tolerance, 3000);
	}

	/**
	 * Solve with the function, guess, tolerance and the maximum number of iterations.
	 */
    public List<PetkovicResult> solve(Function function, double guess, double tolerance, int maxIterations) throws Exception {
		return petkovic(function, guess, tolerance, maxIterations);
	}

	/**
	 * Solve with the function and tolerance.
	 * @throws Exception 
	 */
    public List<PetkovicResult> solve(Function function, double tolerance) throws Exception {
		return petkovic(function, 0, tolerance, 3000);
	}
	
}