package br.edu.ufcg.msnlab.methods.petkovicsimultaneo;

import java.util.*;

import br.edu.ufcg.msnlab.misc.Function;

/**
 * @author Otacilio Freitas de Lacerda
 */
public class PetkovicSimultaneoSolverImpl implements PetkovicSimultaneoSolver {
	
	private double root = Double.NaN;
    private double tolerance = 0;
    private double maxIterations = 3000;
	
	/**
	 * This method do the Petkovic.
	 * @param g The function.
	 * @param guess The initial guess.
	 * @param tolerance The tolerance.
	 * @param maxIterations Maximum numbers of iterations.
	 * @return A list with the results of each iteration.
	 */
    public List<PetkovicSimultaneoResult> petkovic(Function g, double guess, double tolerance, double maxIterations){
		
//        boolean testConv = true;
//        double iterN = 0;
//        double diff = 1e300;
//	    double[] f = {g.calculate(guess), g.derivative().calculate(guess)};
//	    this.tolerance = tolerance;
//	    this.maxIterations = maxIterations;
//	    List<PetkovicResult> results = new ArrayList<PetkovicResult>();
//
//	    if(isNaN(f[0]) || isNaN(f[1])){
//	    	results.add(new PetkovicResultImpl(Double.NaN));
//	    }
//        while(testConv){
//            diff = f[0]/f[1];
//            results.add(new PetkovicResultImpl(f[0]));
//            if(f[0]==0.0D || Math.abs(diff)<this.tolerance){
//                this.root = guess;
//                results.add(new PetkovicResultImpl(this.root));
//                testConv=false;
//            }
//            else{
//                guess -= diff;
//                f[0] = g.calculate(guess);
//                f[1] = g.derivative().calculate(guess);
//	            if(isNaN(f[0]) || isNaN(f[1])){
//	            	results.add(new PetkovicResultImpl(Double.NaN));
//	            }
//            }
//            iterN++;
//            if(iterN>this.maxIterations){
//                this.root = guess;
//                results.add(new PetkovicResultImpl(this.root));
//                testConv = false;
//            }
//        }
//        return results;
    	return null;
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
    public List<PetkovicSimultaneoResult> solve(Function function, double guess, double tolerance) throws Exception {
		return petkovic(function, guess, tolerance, 3000);
	}

	/**
	 * Solve with the function, guess, tolerance and the maximum number of iterations.
	 */
    public List<PetkovicSimultaneoResult> solve(Function function, double guess, double tolerance, int maxIterations) throws Exception {
		return petkovic(function, guess, tolerance, maxIterations);
	}

	/**
	 * Solve with the function and tolerance.
	 */
    public List<PetkovicSimultaneoResult> solve(Function function, double tolerance) {
		return petkovic(function, 0, tolerance, 3000);
	}
	
}