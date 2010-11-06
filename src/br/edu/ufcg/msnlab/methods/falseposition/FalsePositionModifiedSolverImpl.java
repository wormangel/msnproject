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
public class FalsePositionModifiedSolverImpl implements FalsePositionModifiedSolver {

	/* (non-Javadoc)
	 * @see methods.FalsePositionModifiedSolver#solve(misc.Function, double, double, double)
	 */
	public List<FalsePositionModifiedResult> solve(Function funcion, double min,
			double max, double tolerance) throws FalsePositionModifiedException {
		return falsePositionModified(funcion, min, max, tolerance, 100);
	}

	/* (non-Javadoc)
	 * @see methods.FalsePositionModifiedSolver#solve(misc.Function, double, double, double, int)
	 */
	public List<FalsePositionModifiedResult> solve(Function funcion, double min, double max, double tolerance, int maxIterations) throws FalsePositionModifiedException {
		return falsePositionModified(funcion, min, max, tolerance, maxIterations);
	}

	private List<FalsePositionModifiedResult> falsePositionModified(
			Function funcion, double min, double max, double tolerance, int maxIterations) throws FalsePositionModifiedException {
		List<FalsePositionModifiedResult> lista = new ArrayList<FalsePositionModifiedResult>(); 
		int cont = 0;
		
		if (max <= min){
        	throw new FalsePositionModifiedException("Err: The value of max is less equal than to the value of min");
        }
		
		double limMax = maxIterations;
		double inicioIntervalo = min;
		double fimIntervalo = max;
		double fDeA = funcion.calculate(min);
		double fDeB = funcion.calculate(max);
		double fDaAproximacaoAnterior = fDeA;
		
		
		if (Double.isNaN(fDeA) || Double.isNaN(fDeB)){
        	throw new FalsePositionModifiedException(
            "Err: f(a) or f(b) is not a number");
        }       
		
		// Checa as condicoes para a execucao do metodo
        if (fDeA * fDeB >= 0 ) {
            throw new FalsePositionModifiedException(
                    "Err: f(a) * f(b) is not less than zero");
        }
        testePrimeiraDerivada(funcion, inicioIntervalo, fimIntervalo);
        
        double aproximacao = ((inicioIntervalo*fDeB) - (fimIntervalo*fDeA))/(fDeB - fDeA);
		double fDaAproximacao = funcion.calculate(aproximacao);
		//Verifica se o resultado obtido pelo calculo de f(x) eh um numero
        if (Double.isNaN(fDaAproximacao)){
        	throw new FalsePositionModifiedException(
            "Err: f(" +aproximacao + ") is not a number");
        }
        
		lista.add(new FalsePositionModifiedResultImpl(inicioIntervalo, fimIntervalo,
                fDaAproximacao));

		while ( ( Math.abs(fDaAproximacao) > tolerance ) && ( cont <= limMax ) ){
			if ( fDeA*fDaAproximacao >= 0){
				inicioIntervalo = aproximacao;
				fDeA = fDaAproximacao;
				if (fDaAproximacaoAnterior*fDaAproximacao > 0){
					fDeB = fDeB / 2.0;
				}
			}
			else{
				fimIntervalo = aproximacao;
				fDeB = fDaAproximacao;
				if (fDaAproximacaoAnterior*fDaAproximacao > 0){
					fDeA = fDeA / 2.0;
				}
			}
			testePrimeiraDerivada(funcion, inicioIntervalo, fimIntervalo);
			aproximacao = ((inicioIntervalo*fDeB) - (fimIntervalo*fDeA))/(fDeB - fDeA);
			fDaAproximacao = funcion.calculate(aproximacao);
			//Verifica se o resultado obtido pelo calculo de f(x) eh um numero
	        if (Double.isNaN(fDaAproximacao)){
	        	throw new FalsePositionModifiedException(
	            "Err: f(" +aproximacao + ") is not a number");
	        }
			
			lista.add(new FalsePositionModifiedResultImpl(inicioIntervalo, fimIntervalo,
	                aproximacao));
			cont++;
		}
		
		if (cont > limMax) {
            throw new FalsePositionModifiedException(
                    "Err: number of iterations was not sufficient to achieve the result with tolerance informed");
        }
		return lista;
	}
	private void testePrimeiraDerivada(Function funcion, double min, double max)
	throws FalsePositionModifiedException{
		double fLinhaDeA;
		double fLinhaDeB;
		fLinhaDeA = funcion.derivative().calculate(min);
		fLinhaDeB = funcion.derivative().calculate(max);


//		Verifica se o resultado obtido pelo calculo de f'(x) eh um numero
		if (Double.isNaN(fLinhaDeA) || Double.isNaN(fLinhaDeB)){
			throw new FalsePositionModifiedException(
			"Err: f'(a) or f'(b) is not a number");
		}
//		Verifica se o sinal da derivada eh constante
		if (fLinhaDeA * fLinhaDeB < 0){
			throw new FalsePositionModifiedException("Err: Signal derivate of the function is not constant");
		}
	}
	

	/* (non-Javadoc)
	 * @see methods.Solver#solve(misc.Function, double)
	 */
	public List<FalsePositionModifiedResult> solve(Function funcion, double tolerance) {
		// TODO Auto-generated method stub
		return null;
	}

}
