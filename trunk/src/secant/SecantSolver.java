package secant;

import java.util.List;

import methods.Solver;
import misc.Function;

/**
 * TODO
 * @author Alfeu Buriti
 * @author Brunno Guimarães
 * @author Andrea Alves
 * @author Erick Moreno
 * @author Rodrigo Barbosa
 * @author Samuel de Barros
 */
public interface SecantSolver extends Solver<SecantResult> {

    /**
     * TODO
     * @param funcion
     * @param min
     * @param max
     * @param tolerance
     * @return
     */
    public List<SecantResult> solve(Function funcion, double min, double max,
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
    public List<SecantResult> solve(Function funcion, double min, double max,
            double tolerance, int maxIterations);

}
