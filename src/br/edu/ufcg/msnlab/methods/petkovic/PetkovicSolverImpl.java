package br.edu.ufcg.msnlab.methods.petkovic;

import java.util.*;

import mfc.field.Complex;

import br.edu.ufcg.msnlab.misc.Function;

/**
 * @author Otacilio Freitas de Lacerda
 * @author Lucas Medeiros de Azevedo.
 */
public class PetkovicSolverImpl implements PetkovicSolver {
	
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
        double iterN = 1;
        
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
        	results.add(new PetkovicResultImpl(complexGuess)); // adiciona a estimativa da vez
        	
        	Complex diffNewton = f[0].divide(f[1]);
        	
        	Complex fDeXmenosDerivada = g.calculate(complexGuess.minus(diffNewton));
        	Complex valorDentroRaiz = new Complex(1).minus( fDeXmenosDerivada.times(4).divide(f[0]) );
        	
        	Complex numerator = diffNewton.times(2);
        	Complex valorDaRaiz;
        	
        	valorDaRaiz = valorDentroRaiz.sqrt();
        	
        	Complex  denominator = new Complex(1).minus(valorDaRaiz).abs() > new Complex(1).plus(valorDaRaiz).abs() ? new Complex(1).minus(valorDaRaiz) : new Complex(1).plus(valorDaRaiz);
        	
        	diff = numerator.divide(denominator); 
        	
            complexGuess = complexGuess.minus(diff);        	
        	
            if(f[0].equals(new Complex(0)) || diff.abs()<this.tolerance || iterN>this.maxIterations-1){
                testConv=false;
            }
            else{
            	iterN++;

                f[0] = g.calculate(complexGuess);
                f[1] = g.derivative().calculate(complexGuess);
	            if(isNaN(f[0]) || isNaN(f[1])){
	            	results.add(new PetkovicResultImpl(new Complex(Double.NaN)));
	            }
            }

        }
        return results;
    }
	
	private boolean isNaN(Complex complex) {
		return complex.isNaN();
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