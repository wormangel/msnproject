/**
 * 
 */
package br.edu.ufcg.msnlab.methods.muller;

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
public interface MullerResult extends Result {
	
	/**
	 * TODO
	 * @return
	 */
	public double getX0();
	
	/**
	 * TODO
	 * @return
	 */
	public double getX1();
	
	/**
	 * TODO
	 * @return
	 */
	public double getX2();
	
	public double getX();

}
