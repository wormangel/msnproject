/**
 * 
 */
package br.edu.ufcg.msnlab.methods.newtonraphson;

import java.util.List;

import br.edu.ufcg.msnlab.methods.Solver;
import br.edu.ufcg.msnlab.misc.Function;


/**
 * TODO
 * @author Alfeu Buriti
 * @author Brunno Guimarães
 * @author Andrea Alves
 * @author Erick Moreno
 * @author Rodrigo Barbosa
 * @author Samuel de Barros
 * @author Alvaro Magnum
 * @author Marcus Leite
 */
public interface NewtonRaphsonSolver extends Solver<NewtonRaphsonResult> {

    /**
     * Solve with the function, guess and tolerance.
     * @param funcion The function.
     * @param guess Initial guess.
     * @param tolerance The tolerance.
     * @return A list with the result of each iteration.
     */
    public List<NewtonRaphsonResult> solve(Function funcion, double guess,
            double tolerance) throws Exception;

    /**
     * Solve with the function, guess, tolerance and the maximum number of iterations.
     * @param funcion The function.
     * @param guess Initial guess.
     * @param tolerance The tolerance.
     * @param maxIterations Maximum number of iterations.
     * @return A list with the result of each iteration.
     */
    public List<NewtonRaphsonResult> solve(Function funcion, double guess,
            double tolerance, int maxIterations) throws Exception;

}
