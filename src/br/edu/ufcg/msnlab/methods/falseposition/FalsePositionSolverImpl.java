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
package br.edu.ufcg.msnlab.methods.falseposition;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.msnlab.misc.Function;

/**
 * @author Vinicius Marques Aguiar
 *
 */
public class FalsePositionSolverImpl implements FalsePositionSolver {

	/* (non-Javadoc)
	 * @see methods.FalsePositionSolver#solve(misc.Function, double, double, double)
	 */
	public List<FalsePositionResult> solve(Function funcion, double min,
			double max, double tolerance) throws FalsePositionException {
		return falsePosition(funcion, min, max, tolerance, 100);
	}

	/* (non-Javadoc)
	 * @see methods.FalsePositionSolver#solve(misc.Function, double, double, double, int)
	 */
	public List<FalsePositionResult> solve(Function funcion, double min, double max, double tolerance, int maxIterations) throws FalsePositionException {
		return falsePosition(funcion, min, max, tolerance, maxIterations);
	}

	private List<FalsePositionResult> falsePosition(Function funcion,
			double min, double max, double tolerance, int maxIterations) throws FalsePositionException {
		int cont = 0;
		int limMax = maxIterations;
		List<FalsePositionResult> lista = new ArrayList<FalsePositionResult>(); 
		
		if (max <= min){
        	throw new FalsePositionException("Err: The value of max is less equal than to the value of min");
        }
		
		double inicioIntervalo = min;
		double fimIntervalo = max;
		double fDeA = funcion.calculate(min);
		double fDeB = funcion.calculate(max);
		
		if (Double.isNaN(fDeA) || Double.isNaN(fDeB)){
        	throw new FalsePositionException(
            "Err: f(a) or f(b) is not a number");
        }
		
		testePrimeiraDerivada(funcion, inicioIntervalo, fimIntervalo);
        
		
		// Checa as condicoes para a execucao do metodo
        if (fDeA * fDeB >= 0 ) {
            throw new FalsePositionException(
                    "Err: f(a) * f(b) is not less than zero");
        }
		
        
        
		double aproximacao = ((inicioIntervalo*fDeB) - (fimIntervalo*fDeA))/(fDeB - fDeA);
		double fDaAproximacao = funcion.calculate(aproximacao);
		//Verifica se o resultado obtido pelo calculo de f(x) eh um numero
        if (Double.isNaN(fDaAproximacao)){
        	throw new FalsePositionException(
            "Err: f(" +aproximacao + ") is not a number");
        }
		
		lista.add(new FalsePositionResultImpl(inicioIntervalo, fimIntervalo, aproximacao));
		while ( ( Math.abs(fDaAproximacao) > tolerance ) && ( cont <= limMax ) ){
			if ( fDeA*fDaAproximacao >= 0){
				inicioIntervalo = aproximacao;
				fDeA = fDaAproximacao;
			}
			else{
				fimIntervalo = aproximacao;
				fDeB = fDaAproximacao;
			}
			testePrimeiraDerivada(funcion, inicioIntervalo, fimIntervalo);
			aproximacao = ((inicioIntervalo*fDeB) - (fimIntervalo*fDeA))/(fDeB - fDeA);
			fDaAproximacao = funcion.calculate(aproximacao);
			//Verifica se o resultado obtido pelo calculo de f(x) eh um numero
	        if (Double.isNaN(fDaAproximacao)){
	        	throw new FalsePositionException(
	            "Err: f(" +aproximacao + ") is not a number");
	        }
			lista.add(new FalsePositionResultImpl(inicioIntervalo, fimIntervalo, aproximacao));
			cont++;
		}
		
		if (cont > limMax) {
            throw new FalsePositionException(
                    "Err: number of iterations was not sufficient to achieve the result with tolerance informed");
        }
		
		return lista;
	}
	
	private void testePrimeiraDerivada(Function funcion, double min, double max)
	throws FalsePositionException{
		double fLinhaDeA;
		double fLinhaDeB;
		fLinhaDeA = funcion.derivative().calculate(min);
		fLinhaDeB = funcion.derivative().calculate(max);


//		Verifica se o resultado obtido pelo calculo de f'(x) eh um numero
		if (Double.isNaN(fLinhaDeA) || Double.isNaN(fLinhaDeB)){
			throw new FalsePositionException(
			"Err: f'(a) or f'(b) is not a number");
		}
//		Verifica se o sinal da derivada eh constante
		if (fLinhaDeA * fLinhaDeB < 0){
			throw new FalsePositionException("Err: Signal derivate of the function is not constant");
		}
	}

	/* (non-Javadoc)
	 * @see methods.Solver#solve(misc.Function, double)
	 */
	public List<FalsePositionResult> solve(Function funcion, double tolerance) {
		// TODO Auto-generated method stub
		return null;
	}

}
