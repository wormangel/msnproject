/**
 * 
 */
package br.edu.ufcg.msnlab.methods.laguerre;

import java.util.List;

import br.edu.ufcg.msnlab.methods.GuessSolver;
import br.edu.ufcg.msnlab.misc.Function;


/**
 * TODO
 * @author Alfeu Buriti
 * @author Brunno Guimar�es
 * @author Andrea Alves
 * @author Erick Moreno
 * @author Rodrigo Barbosa
 * @author Samuel de Barros
 */
public interface LaguerreSolver extends GuessSolver<LaguerreResult> {

    /**
     * TODO
     * @param funcion
     * @param guess
     * @param tolerance
     * @return
     */
    public List<LaguerreResult> solve(Function function, double guess,
            double tolerance);

    /**
     * TODO
     * @param funcion
     * @param guess
     * @param tolerance
     * @param maxIterations
     * @return
     */
    public List<LaguerreResult> solve(Function function, double guess,
            double tolerance, int maxIterations);

}
