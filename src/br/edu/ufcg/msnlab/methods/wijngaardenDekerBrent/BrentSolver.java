/**
 * 
 */
package br.edu.ufcg.msnlab.methods.wijngaardenDekerBrent;

import java.util.List;

import br.edu.ufcg.msnlab.methods.Solver;
import br.edu.ufcg.msnlab.misc.Function;


/**
 * TODO
 * @author Alfeu Buriti
 * @author Brunno Guimar�es
 * @author Andrea Alves
 * @author Erick Moreno
 * @author Rodrigo Barbosa
 * @author Samuel de Barros
 * @author Gabriel Feitosa
 * @author Rafael Pessoa
 */
public interface BrentSolver extends Solver<BrentResult> {

    /**
     * TODO
     * @param function
     * @param min
     * @param max
     * @param tolerance
     * @return
     * @throws WijngaardenDekerBrentException
     */
    public List<BrentResult> solve(Function function, double min, double max,
            double tolerance) throws WijngaardenDekerBrentException;

    /**
     * TODO
     * @param function
     * @param min
     * @param max
     * @param tolerance
     * @param maxIterations
     * @return
     * @throws WijngaardenDekerBrentException
     */
    public List<BrentResult> solve(Function function, double min, double max,
            double tolerance, int maxIterations)
            throws WijngaardenDekerBrentException;

}
