package br.edu.ufcg.msnlab.methods.petkovicsimultaneo;

/**
 * @author Otacilio Freitas de Lacerda
 */
public class PetkovicSimultaneoResultImpl implements PetkovicSimultaneoResult{
	
	private double x;

	/**
	 * Constructor.
	 * @param x
	 */
	public PetkovicSimultaneoResultImpl(double x) {
		this.x = x;
	}
	
	/**
	 * Return x.
	 */
	public double getX() {
		return x;
	}


}