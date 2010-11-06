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

/**
 * @author Vinicius Marques Aguiar
 *
 */
public class FalsePositionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 611316305086839453L;

	/**
	 * @param message
	 */
	public FalsePositionException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public FalsePositionException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public FalsePositionException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
