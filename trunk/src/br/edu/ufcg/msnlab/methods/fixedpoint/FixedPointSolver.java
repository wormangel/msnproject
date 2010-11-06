/**
 * 
 */
package br.edu.ufcg.msnlab.methods.fixedpoint;

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
 */
public interface FixedPointSolver extends Solver<FixedPointResult> {

    /**
     * Solve with the function, the initial guess and tolerance.
     * @param function The function.
     * @param itFunction TODO
     * @param guess Initial guess.
     * @param tolerance The tolerance.
     * @return A list with the result of each iteration.
     * @throws Exception 
     */
    public List<FixedPointResult> solve(Function function, Function itFunction,
            double guess, double tolerance) throws Exception;

    /**
     * TODO
     * @param function The function.
     * @param itFunction TODO
     * @param guess Initial guess.
     * @param tolerance The tolerance.
     * @param maxIteration Maximum number of iterations.
     * @return A list with the result of each iteration.
     */
    public List<FixedPointResult> solve(Function function, Function itFunction,
            double guess, double tolerance, double maxIteration)  throws Exception;
}
