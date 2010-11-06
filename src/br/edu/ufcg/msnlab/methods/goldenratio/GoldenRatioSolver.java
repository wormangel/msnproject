/**
 * 
 */
package br.edu.ufcg.msnlab.methods.goldenratio;

import java.util.List;

import br.edu.ufcg.msnlab.methods.Solver;
import br.edu.ufcg.msnlab.misc.Function;


/**
 * TODO
 * @author Alfeu Buriti
 * @author Brunno Guimar�es
 * @author Andrea Alves
 * @author Erick Moreno
 * @author Rodrigo Barbosa
 * @author Samuel de Barros
 */
public interface GoldenRatioSolver extends Solver<GoldenRatioResult> {

    /**
     * lista o resultado das aproximacoes para achar o zero da funcao
     * @param funcion funcao ao qual se quer saber a raiz
     * @param min o ponto inicial do intervalo
     * @param max o ponto final do intervalo
     * @param tolerance precisao da aproximacao do zero da funcao
     * @return lista com o valor da raiz aproximada da funcao e os valores
     *         obtidos das aproximacoes em iteracoes anteriores
     * @throws GoldenRatioException
     */
    List<GoldenRatioResult> solve(Function funcion, double min, double max,
            double tolerance) throws GoldenRatioException;

    /**
     * lista o resultado das aproximacoes para achar o zero da funcao
     * @param funcion funcao ao qual se quer saber a raiz
     * @param min o ponto inicial do intervalo
     * @param max o ponto final do intervalo
     * @param tolerance precisao da aproximacao do zero da funcao
     * @param maxIterations numero maximo de iteracoes feita pelo metodo
     * @return lista com o valor da raiz aproximada da funcao e os valores
     *         obtidos das aproximacoes em iteracoes anteriores
     * @throws GoldenRatioException
     */
    List<GoldenRatioResult> solve(Function funcion, double min, double max,
            double tolerance, int maxIterations) throws GoldenRatioException;

}
