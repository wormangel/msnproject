/**
 * 
 */
package br.edu.ufcg.msnlab.methods.bissec;

import java.util.List;

import br.edu.ufcg.msnlab.methods.BissecException;
import br.edu.ufcg.msnlab.methods.MinMaxSolver;
import br.edu.ufcg.msnlab.misc.Function;


/**
 * TODO
 * @author Alfeu Buriti
 * @author Brunno Guimarães
 * @author Andrea Alves
 * @author Erick Moreno
 * @author Rodrigo Barbosa
 * @author Samuel de Barros
 */
public interface BissecSolver extends MinMaxSolver<BissecResult> {

    /**
     * lista o resultado das aproximacoes para achar o zero da funcao
     * @param funcion funcao ao qual se quer saber a raiz
     * @param min o ponto inicial do intervalo
     * @param max o ponto final do intervalo
     * @param tolerance precisao da aproximacao do zero da funcao
     * @return lista com o valor da raiz aproximada da funcao e os valores
     *         obtidos das aproximacoes em iteracoes anteriores
     * @throws BissecException caso o numero de iteracoes ultrapasse o limite ou
     *             caso as condicoes basicas para a execucao do metodo nao sejam
     *             satisfeitas
     */
    List<BissecResult> solve(Function funcion, double min, double max,
            double tolerance) throws BissecException;

    /**
     * lista o resultado das aproximacoes para achar o zero da funcao
     * @param funcion funcao ao qual se quer saber a raiz
     * @param min o ponto inicial do intervalo
     * @param max o ponto final do intervalo
     * @param tolerance precisao da aproximacao do zero da funcao
     * @param maxIterations numero maximo de iteracoes feita pelo metodo
     * @return lista com o valor da raiz aproximada da funcao e os valores
     *         obtidos das aproximacoes em iteracoes anteriores
     * @throws BissecException caso o numero de iteracoes ultrapasse o limite ou
     *             caso as condicoes basicas para a execucao do metodo nao sejam
     *             satisfeitas
     */
    List<BissecResult> solve(Function funcion, double min, double max,
            double tolerance, int maxIterations) throws BissecException;

}
