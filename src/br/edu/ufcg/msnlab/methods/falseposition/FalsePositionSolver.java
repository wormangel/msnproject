/**
 * 
 */
package br.edu.ufcg.msnlab.methods.falseposition;

import java.util.List;

import br.edu.ufcg.msnlab.methods.MinMaxSolver;
import br.edu.ufcg.msnlab.misc.Function;



/**
 * TODO
 * 
 * @author Alfeu Buriti
 * @author Brunno Guimarães
 * 
 * @author Andrea Alves
 * @author Erick Moreno
 * 
 * @author Rodrigo Barbosa
 * @author Samuel de Barros
 *
 */
public interface FalsePositionSolver extends MinMaxSolver<FalsePositionResult> {

	/**
	 * TODO
	 * @param funcion
	 * @param min
	 * @param max
	 * @param tolerance
	 * @return
	 * @throws FalsePositionException 
	 */
	List<FalsePositionResult> solve(Function funcion, double min, double max, double tolerance) throws FalsePositionException;
	
	/**
	 * TODO
	 * @param funcion
	 * @param min
	 * @param max
	 * @param tolerance
	 * @param maxIterations
	 * @return
	 * @throws FalsePositionException 
	 */
	List<FalsePositionResult> solve(Function funcion, double min, double max, double tolerance, int maxIterations) throws FalsePositionException;
}
