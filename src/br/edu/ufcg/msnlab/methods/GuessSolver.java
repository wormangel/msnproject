package br.edu.ufcg.msnlab.methods;

import java.util.List;

import br.edu.ufcg.msnlab.misc.Function;

public interface GuessSolver<T> extends Solver<T> {
	public List<T> solve(Function funcion, double guess, double tolerance) throws Exception;
	public List<T> solve(Function funcion, double guess, double tolerance, int maxIterations) throws Exception;
}
