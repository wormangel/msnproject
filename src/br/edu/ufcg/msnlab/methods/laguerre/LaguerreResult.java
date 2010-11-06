/**
 * 
 */
package br.edu.ufcg.msnlab.methods.laguerre;

import br.edu.ufcg.msnlab.methods.Result;
import mfc.field.Complex;

/**
 * TODO
 * @author Alfeu Buriti
 * @author Brunno Guimar�es
 * @author Andrea Alves
 * @author Erick Moreno
 * @author Rodrigo Barbosa
 * @author Samuel de Barros
 */
public interface LaguerreResult extends Result {

    /**
     * TODO
     * @return
     */
    public double getGuess();

    public double getX();
    
    public Complex getComplexX();

}
