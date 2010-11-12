package br.edu.ufcg.msnlab.methods.petkovic;

import mfc.field.Complex;
import br.edu.ufcg.msnlab.methods.Result;

/**
 * @author Otacilio Freitas de Lacerda
 * @author Lucas Medeiros de Azevedo.
 */
public interface PetkovicResult extends Result {
	
	/**
	 * Get x.
	 * @return x
	 */
	public double getX();
	
	public String getComplexX();
	
	public boolean isComplex();

}
