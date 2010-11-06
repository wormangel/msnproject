package br.edu.ufcg.msnlab.methods.laguerre;

import mfc.field.Complex;


/**
 * Laguerre Method Result
 * 
 * @author Marcus Williams
 * @author Carla Araujo
 *
 */
public class LaguerreResultImpl implements LaguerreResult {

    private Complex x;
    private double guess;

    public LaguerreResultImpl(double guess, Complex x) {
        this.guess = guess;
        this.x = x;
    }

    public double getGuess() {
        return guess;
    }

    public double getX() {
        return x.getRe();
    }
    
    public Complex getComplexX() {
        return x;
    }

}
