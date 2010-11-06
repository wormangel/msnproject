/**
 * 
 */
package br.edu.ufcg.msnlab.methods.falseposition;

import java.util.List;

import br.edu.ufcg.msnlab.methods.Solver;
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
public interface FalsePositionModifiedSolver extends Solver<FalsePositionModifiedResult> {

	/**
	 * TODO
	 * @param funcion
	 * @param min
	 * @param max
	 * @param tolerance
	 * @return
	 * @throws FalsePositionModifiedException 
	 */
	public List<FalsePositionModifiedResult> solve(Function funcion, double min, double max, double tolerance) throws FalsePositionModifiedException;
	
	/**
	 * TODO
	 * @param funcion
	 * @param min
	 * @param max
	 * @param tolerance
	 * @param maxIterations
	 * @return
	 * @throws FalsePositionModifiedException 
	 */
	public List<FalsePositionModifiedResult> solve(Function funcion, double min, double max, double tolerance, int maxIterations) throws FalsePositionModifiedException;
}
