/**
 * 
 */
package br.edu.ufcg.msnlab.methods.wijngaardenDekerBrent;

import br.edu.ufcg.msnlab.methods.Result;

/**
 * TODO
 * 
 * @author Alfeu Buriti
 * @author Brunno Guimar�es
 * 
 * @author Andrea Alves
 * @author Erick Moreno
 * 
 * @author Rodrigo Barbosa
 * @author Samuel de Barros
 *
 * @author Gabriel Feitosa
 * @author Rafael Pessoa
 */
public interface BrentResult extends Result {
	
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

	/**
	 * TODO
	 * @return
	 */
	public int getIteration();

	/**
	 * TODO
	 * 
	 */
	public void setIteration(int iteration);

	/**
	 * TODO
	 * @return
	 */
	public double getError();
	
	/**
	 * TODO
	 */
	public void setError(double error);
	
	/**
	 * TODO
	 * 
	 */
	public void setX(double x);

	/**
	 * TODO
	 * @return
	 */
	public double getFx();
	
	/**
	 * TODO
	 */
	public void setFx(double fx);

}
