package br.edu.ufcg.msnlab.methods.petkovic;

/**
 * @author Otacilio Freitas de Lacerda
 */
public class PetkovicResultImpl implements PetkovicResult{
	
	private double x;

	/**
	 * Constructor.
	 * @param x
	 */
	public PetkovicResultImpl(double x) {
		this.x = x;
	}
	
	/**
	 * Return x.
	 */
	public double getX() {
		return x;
	}


}