/**
 * 
 */
package br.edu.ufcg.msnlab.methods.ridders;

import java.util.List;

import br.edu.ufcg.msnlab.methods.MinMaxSolver;
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
public interface RiddersSolver extends MinMaxSolver<RiddersResult> {

    /**
     * TODO
     * @param funcion
     * @param min
     * @param max
     * @param tolerance
     * @return
     */
    public List<RiddersResult> solve(Function funcion, double min, double max,
            double tolerance);

    /**
     * TODO
     * @param funcion
     * @param min
     * @param max
     * @param tolerance
     * @param maxIterations
     * @return
     */
    public List<RiddersResult> solve(Function funcion, double min, double max,
            double tolerance, int maxIterations);

}
