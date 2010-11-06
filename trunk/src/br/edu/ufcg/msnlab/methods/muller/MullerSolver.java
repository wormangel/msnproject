/**
 * 
 */
package br.edu.ufcg.msnlab.methods.muller;

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
public interface MullerSolver extends Solver<MullerResult> {

    /**
     * TODO
     * @param funcion
     * @param x0
     * @param x1
     * @param x2
     * @param tolerance
     * @return
     */
    public List<MullerResult> solve(Function funcion, double x0, double x1,
            double x2, double tolerance);

    /**
     * TODO
     * @param funcion
     * @param x0
     * @param x1
     * @param x2
     * @param tolerance
     * @param maxIterations
     * @return
     */
    public List<MullerResult> solve(Function funcion, double x0, double x1,
            double x2, double tolerance, int maxIterations);
}
