/**
 * 
 */
package secant;

import methods.Result;

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
public interface SecantResult extends Result {
	
	/**
	 * TODO
	 * @return
	 */
	public double getMin();
	
	/**
	 * TODO
	 * @return
	 */
	public double getMax();
	
	public double getX();

}
