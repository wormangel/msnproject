package methods;

import java.util.List;

import misc.Function;

public interface Solver<T> {
	
	/**
	 * TODO
	 * @param funcion
	 * @param tolerance
	 * @return
	 */
	public List<T> solve(Function funcion, double tolerance);

}
