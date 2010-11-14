package br.edu.ufcg.msnlab.misc;

public class BatchResultImpl implements BatchResult {

	private Function func;
	private long time;
	
	public BatchResultImpl(Function func, long time){
		this.func = func;
		this.time = time;
	}
	
	public Function getFunction() {
		return this.func;
	}

	public long getTime() {
		return this.time;
	}

}
