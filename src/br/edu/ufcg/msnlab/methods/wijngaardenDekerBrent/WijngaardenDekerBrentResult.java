package br.edu.ufcg.msnlab.methods.wijngaardenDekerBrent;


public class WijngaardenDekerBrentResult implements BrentResult{

	private double x;
	private double fx;
	private int iteration;
	private double error;
	
	public double getMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getMin() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getX() {
		return x;
	}

	public double getError() {
		return error;
	}
	
	public void setError(double error){
		this.error = error;
	}

	public int getIteration() {
		return iteration;
	}
	
	public void setIteration(int iteration) {
		this.iteration = iteration;
	}

	public void setX(double x){
		this.x = x;
	}

	public double getFx() {
		return fx;
	}

	public void setFx(double fx) {
		this.fx = fx;
		
	}
}
