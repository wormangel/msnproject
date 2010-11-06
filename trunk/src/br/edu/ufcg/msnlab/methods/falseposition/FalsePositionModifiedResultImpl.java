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
 */
public class FalsePositionModifiedResultImpl implements
        FalsePositionModifiedResult {

    private double x;
    private double max;
    private double min;

    public FalsePositionModifiedResultImpl(double min, double max, double x) {
        setMin(min);
        setMax(max);
        setX(x);
    }

    /**
     * altera o valor do menor ponto do intervalo
     * @param min o valor do menor ponto do intervalo
     */
    private void setMin(double min) {
        this.min = min;

    }

    /**
     * altera o valor do maior ponto do intervalo
     * @param max o valor do maior ponto do intervalo
     */
    private void setMax(double max) {
        this.max = max;

    }

    /**
     * altera o valor da aproximacao
     * @param x o valor para a aproximacao
     */
    private void setX(double x) {
        this.x = x;

    }

    /*
     * (non-Javadoc)
     * @see methods.FalsePositionModifiedResult#getMax()
     */
    public double getMax() {
        // TODO Auto-generated method stub
        return max;
    }

    /*
     * (non-Javadoc)
     * @see methods.FalsePositionModifiedResult#getMin()
     */
    public double getMin() {
        // TODO Auto-generated method stub
        return min;
    }

    /*
     * (non-Javadoc)
     * @see methods.Result#getX()
     */
    public double getX() {
        // TODO Auto-generated method stub
        return x;
    }

}
