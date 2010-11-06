package br.edu.ufcg.msnlab.methods.muller;

/**
 * 
 * @author Eugenia de Sousa
 * @author Jaluska Rodrigues
 * 
 */
public class MullerResultImpl implements MullerResult{

	private double x0;
	private double x1;
	private double x2;
	private double result;
	
	public MullerResultImpl(double x0,double x1, double x2, double x){
		this.x0 = x0;
		this.x1= x1;
		this.x2 = x2;
		this.result = x;
	}
	
	public double getX0() {
		// TODO Auto-generated method stub
		return x0;
	}

	public double getX1() {
		// TODO Auto-generated method stub
		return x1;
	}

	public double getX2() {
		// TODO Auto-generated method stub
		return x2;
	}

	public double getX() {
		// TODO Auto-generated method stub
		return result;
	}

}
