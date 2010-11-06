/**
 * 
 */
package br.edu.ufcg.msnlab.methods.falseposition;

import br.edu.ufcg.msnlab.methods.Result;

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
public interface FalsePositionResult extends Result {
	
	/**
	 * TODO
	 * @return
	 */
	double getMin();
	
	/**
	 * TODO
	 * @return
	 */
	double getMax();
	
	/**
     * TODO
     * @return
     */
    double getX();

}
