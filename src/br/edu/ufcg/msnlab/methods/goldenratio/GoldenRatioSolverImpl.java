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
package br.edu.ufcg.msnlab.methods.goldenratio;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.msnlab.misc.Function;

/**
 * @author Vinicius Marques Aguiar
 *
 */
public class GoldenRatioSolverImpl implements GoldenRatioSolver {

	private static final double FI =  1.618;

	/* (non-Javadoc)
	 * @see methods.GoldenRatioSolver#solve(misc.Function, double, double, double)
	 */
	public List<GoldenRatioResult> solve(Function funcion, double min,
			double max, double tolerance) throws GoldenRatioException {
		return goldenRatio(funcion, min, max, tolerance, 50);
	}

	/* (non-Javadoc)
	 * @see methods.GoldenRatioSolver#solve(misc.Function, double, double, double, int)
	 */
	public List<GoldenRatioResult> solve(Function funcion, double min,
			double max, double tolerance, int maxIterations) throws GoldenRatioException {
		return goldenRatio(funcion, min, max, tolerance, maxIterations);
	}

	private List<GoldenRatioResult> goldenRatio(Function funcion, double min,
			double max, double tolerance, int maxIterations) throws GoldenRatioException {
		List<GoldenRatioResult> lista = new ArrayList<GoldenRatioResult>();
		int cont = 0;
		int limMax = maxIterations;
		
		if (max <= min){
        	throw new GoldenRatioException("Err: The value of max is less equal than to the value of min");
        }
		
		double inicioIntervalo = min;
		double fimIntervalo = max;
		double fDeA = funcion.calculate(min);
		double fDeB = funcion.calculate(max);
		
		if (Double.isNaN(fDeA) || Double.isNaN(fDeB)){
        	throw new GoldenRatioException(
            "Err: f(a) or f(b) is not a number");
        }
	
		if (fDeA * fDeB >= 0 ) {
            throw new GoldenRatioException(
                    "Err: f(a) * f(b) is not less than zero");
        }
		
		testePrimeiraDerivada(funcion, inicioIntervalo, fimIntervalo);
		
		double pontoAureo = (fimIntervalo + inicioIntervalo*(GoldenRatioSolverImpl.FI - 1))/(GoldenRatioSolverImpl.FI);
		double fDoPontoAureo = funcion.calculate(pontoAureo);
		
		//Verifica se o resultado obtido pelo calculo de f(x) eh um numero
        if (Double.isNaN(fDoPontoAureo)){
        	throw new GoldenRatioException(
            "Err: f(" +pontoAureo + ") is not a number");
        }
		
		lista.add(new GoldenRatioResultImpl(inicioIntervalo, fimIntervalo, pontoAureo));
		while ( ( Math.abs(fDoPontoAureo) > tolerance ) && ( cont <= limMax ) ){
			if ( fDeA*fDoPontoAureo > 0){
				inicioIntervalo = pontoAureo;	
			}
			else{
				fimIntervalo = pontoAureo;
			}
			
			testePrimeiraDerivada(funcion, inicioIntervalo, fimIntervalo);
			
			pontoAureo = (fimIntervalo + inicioIntervalo*(GoldenRatioSolverImpl.FI - 1))/(GoldenRatioSolverImpl.FI);
			fDoPontoAureo = funcion.calculate(pontoAureo);
			//Verifica se o resultado obtido pelo calculo de f(x) eh um numero
	        if (Double.isNaN(fDoPontoAureo)){
	        	throw new GoldenRatioException(
	            "Err: f(" +pontoAureo + ") is not a number");
	        }
			lista.add(new GoldenRatioResultImpl(inicioIntervalo, fimIntervalo, pontoAureo));
			cont++;
		}
		
		if (cont > limMax) {
            throw new GoldenRatioException(
                    "Err: number of iterations was not sufficient to achieve the result with tolerance informed");
        }
		return lista;
	}
	private void testePrimeiraDerivada(Function funcion, double min, double max)
	throws GoldenRatioException{
		double fLinhaDeA;
		double fLinhaDeB;
		fLinhaDeA = funcion.derivative().calculate(min);
		fLinhaDeB = funcion.derivative().calculate(max);


//		Verifica se o resultado obtido pelo calculo de f'(x) eh um numero
		if (Double.isNaN(fLinhaDeA) || Double.isNaN(fLinhaDeB)){
			throw new GoldenRatioException(
			"Err: f'(a) or f'(b) is not a number");
		}
//		Verifica se o sinal da derivada eh constante
		if (fLinhaDeA * fLinhaDeB < 0){
			throw new GoldenRatioException("Err: Signal derivate of the function is not constant");
		}
	}

	/* (non-Javadoc)
	 * @see methods.Solver#solve(misc.Function, double)
	 */
	public List<GoldenRatioResult> solve(Function funcion, double tolerance) {
		// TODO Auto-generated method stub
		return null;
	}

}
