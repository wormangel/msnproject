package br.edu.ufcg.msnlab.methods.dekker;

import java.util.List;

import br.edu.ufcg.msnlab.methods.MinMaxSolver;
import br.edu.ufcg.msnlab.misc.Function;


/**
 * TODO DOCUMENT ME!
 * @author Edigley Pereira Fraga
 * @author Jaindson Valentim Santana
 */
public interface DekkerSolver extends MinMaxSolver<DekkerResult> {

    List<DekkerResult> solve(Function funcion, double min, double max,
            double tolerance) throws DekkerException;

    List<DekkerResult> solve(Function funcion, double min, double max,
            double tolerance, int maxIterations) throws DekkerException;

}
