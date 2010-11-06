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




/**
 * @author Vinicius Marques Aguiar
 *
 */
public class BissecResultImpl implements BissecResult {

	private double x;
	private double max;
	private double min;

	/**
	 * Construtor da classe
	 * @param min o menor ponto do intervalo
	 * @param max o maior ponto do intervalo
	 * @param x o valor da aproximacao
	 */
	public BissecResultImpl(double min, double max, double x){
		setMin(min);
		setMax(max);
		setX(x);
	}
	
	/**
	 * altera o valor do menor ponto do intervalo
	 * @param min o valor para o menor ponto do intervalo
	 */
	private void setMin(double min) {
		this.min = min;
		
	}
	
	/**
	 * altera o valor para o maior ponto do intevalo
	 * @param max o valor para o maior ponto do intervalo
	 */
	private void setMax(double max) {
		this.max = max;
		
	}
	
	/**
	 * altera o valor do ponto medio do intervalo
	 * @param x o valor para o ponto medio do intervalo
	 */
	private void setX(double x) {
		this.x = x;
		
	}

	/* (non-Javadoc)
	 * @see methods.BissecResult#getMax()
	 */
	public double getMax() {
		
		return max;
	}

	/* (non-Javadoc)
	 * @see methods.BissecResult#getMin()
	 */
	public double getMin() {
		
		return min;
	}

	/* (non-Javadoc)
	 * @see methods.Result#getX()
	 */
	public double getX() {

		return x;
	}	
}
