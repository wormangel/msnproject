package br.edu.ufcg.msnlab.methods.petkovic;

import mfc.field.Complex;

/**
 * @author Otacilio Freitas de Lacerda
 * @author Lucas Medeiros de Azevedo.
 */
public class PetkovicResultImpl implements PetkovicResult{
	
	private Complex x;

	/**
	 * Constructor.
	 * @param x
	 */
	public PetkovicResultImpl(Complex x) {
		this.x = x;
	}
	
	/**
	 * Return x.
	 */
	public double getX() {
		return x.re;
	}
	
	public String getComplexX() {
		return x.toString();
	}

	public boolean isComplex() {
		if (x.im == 0) {
			return false;
		}
		return true;
	}


}