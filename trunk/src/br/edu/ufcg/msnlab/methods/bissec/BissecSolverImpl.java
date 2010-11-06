/*
 * Universidade Federal de Campina Grande
 * Centro de Engenharia Eletrica e Informatica
 * Unidade Academica de Sistemas e Computacao
 * Curso de Ciencia da Computacao
 * Disciplina: Metodos e Software Numericos
 * Alunos: Davi Oliveira
 *         Vinicius Marques Aguiar
 */
/**
 * 
 */
package br.edu.ufcg.msnlab.methods.bissec;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.msnlab.methods.BissecException;
import br.edu.ufcg.msnlab.misc.Function;

/**
 * @author Vinicius Marques Aguiar
 */
public class BissecSolverImpl implements BissecSolver {

    /*
     * (non-Javadoc)
     * @see methods.BissecSolver#solve(misc.Function, double, double, double)
     */
    public List<BissecResult> solve(Function funcion, double min, double max,
            double tolerance) throws BissecException {
        // por padrao usamos o numero cinquenta para a quantidade maxima de
        // iteracoes
        return bissec(funcion, min, max, tolerance, 50);
    }

    /*
     * (non-Javadoc)
     * @see methods.BissecSolver#solve(misc.Function, double, double, double,
     * int)
     */
    public List<BissecResult> solve(Function funcion, double min, double max,
            double tolerance, int maxIterations) throws BissecException {
        return bissec(funcion, min, max, tolerance, maxIterations);

    }

    private List<BissecResult> bissec(Function funcion, double min, double max,
            double tolerance, int limMax) throws BissecException {

        List<BissecResult> lista = new ArrayList<BissecResult>();

        int cont = 0;
        
        if (max <= min){
        	throw new BissecException("Err: The value of max is less equal than to the value of min");
        }
        double inicioIntervalo = min;
        double fimIntervalo = max;
        double fDeA = funcion.calculate(inicioIntervalo);
        double fDeB = funcion.calculate(fimIntervalo);
                
        //Verifica se o resultado obtido pelo calculo de fx) eh um numero
        if (Double.isNaN(fDeA) || Double.isNaN(fDeB)){
        	throw new BissecException(
            "Err: f(a) or f(b) is not a number");
        }
        // Checa se existe alguma raiz no intervalo
        if (fDeA * fDeB >= 0 ) {
            throw new BissecException(
                    "Err: f(a) * f(b) is not less than zero");
        }
        //Verifica se o resultado obtido pelo calculo de f'(x) eh um numero
        testePrimeiraDerivada(funcion, min,max);
                
        double pontoMedio = (inicioIntervalo + fimIntervalo) / 2.0;
        double fDoPontoMedio = funcion.calculate(pontoMedio);
        
        //Verifica se o resultado obtido pelo calculo de f(x) eh um numero
        if (Double.isNaN(fDoPontoMedio)){
        	throw new BissecException(
            "Err: f(" +pontoMedio + ") is not a number");
        }
        lista.add(new BissecResultImpl(inicioIntervalo, fimIntervalo,
                pontoMedio));

        
        while ((Math.abs(fDoPontoMedio) > tolerance) && (cont <= limMax)) {
        	
            if (fDeA * fDoPontoMedio > 0) {
                inicioIntervalo = pontoMedio;
            } else {
                fimIntervalo = pontoMedio;
            }

            testePrimeiraDerivada(funcion, inicioIntervalo, fimIntervalo);
            
            pontoMedio = (inicioIntervalo + fimIntervalo) / 2.0;
            fDoPontoMedio = funcion.calculate(pontoMedio);
            //Verifica se o resultado obtido pelo calculo de f(x) eh um numero
            if (Double.isNaN(fDoPontoMedio)){
            	throw new BissecException(
                "Err: f(" +pontoMedio + ") is not a number");
            }
            lista.add(new BissecResultImpl(inicioIntervalo, fimIntervalo,
                    pontoMedio));

            cont++;

        } 

        if (cont > limMax) {
            throw new BissecException(
                    "Err: number of iterations was not sufficient to achieve the result with tolerance informed");
        }
        return lista;

    }

	private void testePrimeiraDerivada(Function funcion, double min, double max)
			throws BissecException {
		double fLinhaDeA;
		double fLinhaDeB;
		fLinhaDeA = funcion.derivative().calculate(min);
		fLinhaDeB = funcion.derivative().calculate(max);
		
		
		//Verifica se o resultado obtido pelo calculo de f'(x) eh um numero
		if (Double.isNaN(fLinhaDeA) || Double.isNaN(fLinhaDeB)){
			throw new BissecException(
		    "Err: f'(a) or f'(b) is not a number");
		}
		//Verifica se o sinal da derivada eh constante
		if (fLinhaDeA * fLinhaDeB < 0){
			throw new BissecException("Err: Signal derivate of the function is not constant");
		}
	}

    /*
     * (non-Javadoc)
     * @see methods.Solver#solve(misc.Function, double)
     */
    public List<BissecResult> solve(Function funcion, double tolerance) {
        // TODO Auto-generated method stub
        return null;
    }

}
