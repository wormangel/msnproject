package br.edu.ufcg.msnlab.methods;

import java.util.List;

import br.edu.ufcg.msnlab.misc.Function;

public interface MinMaxSolver<T> extends Solver<T> {
	public List<T> solve(Function funcion, double min, double max, double tolerance) throws Exception;
	public List<T> solve(Function funcion, double min, double max, double tolerance, int maxIterations) throws Exception;
}
