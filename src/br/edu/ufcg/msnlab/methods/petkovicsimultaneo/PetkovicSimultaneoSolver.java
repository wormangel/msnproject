package br.edu.ufcg.msnlab.methods.petkovicsimultaneo;

import java.util.List;

import br.edu.ufcg.msnlab.methods.Solver;
import br.edu.ufcg.msnlab.misc.Function;

/**
 * @author Otacilio Freitas de Lacerda
 */
public interface PetkovicSimultaneoSolver extends Solver<PetkovicSimultaneoResult> {

    /**
     * Solve with the function, guess and tolerance.
     * @param funcion The function.
     * @param guess Initial guess.
     * @param tolerance The tolerance.
     * @return A list with the result of each iteration.
     */
    public List<PetkovicSimultaneoResult> solve(Function funcion, double guess,
            double tolerance) throws Exception;

    /**
     * Solve with the function, guess, tolerance and the maximum number of iterations.
     * @param funcion The function.
     * @param guess Initial guess.
     * @param tolerance The tolerance.
     * @param maxIterations Maximum number of iterations.
     * @return A list with the result of each iteration.
     */
    public List<PetkovicSimultaneoResult> solve(Function funcion, double guess,
            double tolerance, int maxIterations) throws Exception;

}