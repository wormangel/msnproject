package br.edu.ufcg.msnlab.methods.secant;



/**
 * 
 * @author Eugenia de Sousa
 * @author Jaluska Rodrigues
 * 
 */
public class SecantResultImpl implements SecantResult{
	
	private double max;
	private double min;
	private double result;
	
	
	public SecantResultImpl(double min, double max,double result) {
		this.min = min;
		this.max = max;
		this.result = result;
	}

	

	public double getMax() {
		// TODO Auto-generated method stub
		return max;
	}

	public double getMin() {
		// TODO Auto-generated method stub
		return min;
	}



	public double getX() {
		// TODO Auto-generated method stub
		return result;
	}
}
