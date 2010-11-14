
package br.edu.ufcg.msnlab.methods.bus;

import java.util.List;

import br.edu.ufcg.msnlab.methods.MinMaxSolver;
import br.edu.ufcg.msnlab.misc.Function;


/**
 * TODO DOCUMENT ME!
 * 
 * @author Edigley Pereira Fraga
 * @author Jaindson Valentim Santana
 */
public interface BusAlgorithmRSolver extends MinMaxSolver<BusAlgorithmRResult> {

    List<BusAlgorithmRResult> solve(Function funcion, double min, double max, double tolerance)
	    throws BusAlgorithmRException;

    List<BusAlgorithmRResult> solve(Function funcion, double min, double max, double tolerance, int maxIterations)
	    throws BusAlgorithmRException;

}
