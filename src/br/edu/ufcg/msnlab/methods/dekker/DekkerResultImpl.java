package br.edu.ufcg.msnlab.methods.dekker;

/**
 * TODO DOCUMENT ME!
 * @author Edigley Pereira Fraga
 * @author Jaindson Valentim Santana
 */
public class DekkerResultImpl implements DekkerResult {

    private double x;

    public DekkerResultImpl(Double x) {

        super();
        this.x = x;
    }

    public double getX() {

        return this.x;
    }

    public String toString() {

        return String.valueOf(this.x);
    }

}
