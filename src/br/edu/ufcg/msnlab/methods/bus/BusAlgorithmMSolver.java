
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
public interface BusAlgorithmMSolver extends MinMaxSolver<BusAlgorithmMResult> {

    List<BusAlgorithmMResult> solve(Function funcion, double min, double max, double tolerance)
	    throws BusAlgorithmMException;

    List<BusAlgorithmMResult> solve(Function funcion, double min, double max, double tolerance, int maxIterations)
	    throws BusAlgorithmMException;

}
