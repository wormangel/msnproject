package br.edu.ufcg.msnlab.methods.bus;

import static br.edu.ufcg.msnlab.util.Util.isEqual;
import static br.edu.ufcg.msnlab.util.Util.isUnequal;
import static br.edu.ufcg.msnlab.util.Util.liesBetween;
import static java.lang.Math.abs;
import static java.lang.Math.signum;

import java.util.LinkedList;
import java.util.List;

import br.edu.ufcg.msnlab.misc.Function;


/**
 * TODO DOCUMENT ME!
 * @author Edigley Pereira Fraga
 * @author Jaindson Valentim Santana
 */
public class BusAlgorithmMSolverImpl implements BusAlgorithmMSolver {

    private static final int DEFAULT_MAX_ITERATIONS = 50;

    private static final double INF = Double.MAX_VALUE;

    private Function f;

    private double tol;

    private List<Double> bs;

    private List<Double> cs;

    private List<Double> xs;

    public List<BusAlgorithmMResult> solve(Function f, double a, double b,
            double tol) throws BusAlgorithmMException {

        return solve(f, a, b, tol, DEFAULT_MAX_ITERATIONS);
    }

    public List<BusAlgorithmMResult> solve(Function f, double a, double b,
            double tol, int n) throws BusAlgorithmMException {

	int signA = signum(f.calculate(a)) < 0 ? -1 : 1;
	int signB = signum(f.calculate(b)) < 0 ? -1 : 1;
	if(signA == signB){
	    throw new BusAlgorithmMException(String.format("ERROR! The ordinates of the abscissas %f and %f have the same sign.", a, b));
	}
        List<BusAlgorithmMResult> guesses = new LinkedList<BusAlgorithmMResult>();

        this.f = f;
        this.tol = tol;
        bs = new LinkedList<Double>();
        cs = new LinkedList<Double>();
        xs = new LinkedList<Double>();

        double x_0 = a;
        double x_1 = b;

        double x_i, a_i, b_i, c_i, lambda_i, p_i, d_i;
        double oldA, oldB, oldC, oldD;
        double x_k;

        // A1 (initialization, i = 1)
        int i = 1;
        int j_i;
        if (abs(f.calculate(x_1)) <= abs(f.calculate(x_0))) {
            b_i = x_1;
            a_i = c_i = x_0;
        } else {
            b_i = x_0;
            a_i = c_i = x_1;
        }
        bs.add(b_i);
        cs.add(c_i);
        xs.add(x_0);
        xs.add(x_1);
        oldB = b_i;
        oldC = c_i;
        oldA = a_i;
        oldD = Double.NaN;// Initialization to avoid compilation error, this
                          // value should never be used.

        // A2 (iteration step, i = 2, ..., n)
        for (i++; i <= n; i++) {

            j_i = getJ();

            if (j_i >= i - 2) {
                lambda_i = l(oldB, oldA);
                x_i = w(lambda_i, oldB, oldC);
            } else if (j_i == i - 3) {
                p_i = r(oldB, oldA, oldD);
                x_i = w(p_i, oldB, oldC);
            } else {
                x_i = m(oldB, oldC);
            }
            xs.add(x_i);

            x_k = getX_K();

            if (abs(f.calculate(x_i)) <= abs(f.calculate(x_k))) {
                b_i = x_i;
                c_i = x_k;
                a_i = oldB;
            } else {
                b_i = x_k;
                a_i = c_i = x_i;
            }

            if (isEqual(b_i, x_i, tol) || isEqual(b_i, oldB, tol)) {
                d_i = oldA;
            } else {
                d_i = oldB;
            }

            // A3 (termination)
            bs.add(b_i);
            cs.add(c_i);
            oldA = a_i;
            oldB = b_i;
            oldC = c_i;
            oldD = d_i;
            guesses.add(new BusAlgorithmMResultImpl(b_i));
            if (abs(b_i - c_i) <= 2 * delta(b_i)) {
                break;
            }
        }

        if (i > n) {
            throw new BusAlgorithmMException(
                    "The best guess was not found in less then " + n
                            + " iterations");
        }

        return guesses;
    }

    private double f(double a, double b) {

        return (f.calculate(a) - f.calculate(b)) / (a - b);
    }

    private double r(double b, double a, double d) {

        double alpha = f(b, d) * f.calculate(a);
        double beta = f(a, d) * f.calculate(b);

        if (isUnequal(beta, alpha, this.tol)) {
            return b - beta * (b - a) / (beta - alpha);
        } else if (isEqual(beta, alpha, this.tol)
                && isUnequal(beta, 0.0, this.tol)) {
            return INF;// TODO How to handle this case?
        } else {
            return 0;
        }

    }

    /**
     * This method returns the largest positive integer satisfying j = 1 or, if
     * 1 < j < i, then | b_j - c_j | <= 1/2 |b_(j-1) - c_(j-1)| (3.1.1)
     * @return
     * @throws BusAlgorithmMException 
     */
    private int getJ() throws BusAlgorithmMException {

        if (bs.size() != cs.size() || bs.size() < 1) {
            throw generateError();
        }

        if (bs.size() == 1) {
            return 1;
        }

        int j = bs.size() - 1;

        for (; j > 1; j--) {

            int tempJ = j - 1;// We need this trick because the list start with
                              // 0.

            if (abs(bs.get(tempJ) - cs.get(tempJ)) <= 0.5 * abs(bs
                    .get(tempJ - 1)
                    - cs.get(tempJ - 1))) {
                break;
            }

        }

        return j;
    }

    /**
     * This method return x_k, where k is the largest (nonegative) integer
     * satisfying k < i and f(x_k) * f(x_i) <= 0
     * @return
     * @throws BusAlgorithmMException 
     */
    private double getX_K() throws BusAlgorithmMException {

        if (this.xs.size() < 1) {
            throw generateError();
        }

        double cX = this.xs.get(this.xs.size() - 1);
        double cK;
        for (int i = this.xs.size() - 1; i >= 0; i--) {
            cK = this.xs.get(i);
            if (this.f.calculate(cK) * this.f.calculate(cX) <= 0) {
                return cK;
            }
        }

        throw generateError();
    }

    /**
     * Calculates the linear interpolation.
     * @param a
     * @param b
     * @param f
     * @return
     */
    private double l(double a, double b) {

        double fa = this.f.calculate(a);
        double fb = this.f.calculate(b);

        if (isUnequal(fa, fb, this.tol)) {
            return b - fb * (b - a) / (fb - fa);
        } else if (isEqual(fa, fb, this.tol) && isUnequal(fa, 0.0, this.tol)) {
            return INF;// TODO How to handle this case?
        } else {
            return b;
        }

    }

    private double h(double b, double c) {

        return b + signum(c - b) * delta(b);
    }

    private double m(double b, double c) {

        return 0.5 * (b + c);
    }

    private double w(double l, double b, double c) {

        if (liesBetween(l, h(b, c), m(b, c), this.tol)) {
            return l;
        } else if (abs(l - b) <= delta(b)
                && liesBetween(l, b, m(b, c), this.tol)) {
            return h(b, c);
        } else {
            return m(b, c);
        }

    }

    /**
     * Tolerance function.
     * @param value
     * @return
     */
    private double delta(double value) {

        return this.tol;
        // return abs(value)*10e-14 + 10e-14;
    }

    public List<BusAlgorithmMResult> solve(Function funcion, double tolerance) {

        throw new UnsupportedOperationException("This operation is not supported by this method");
    }

    private BusAlgorithmMException generateError(){
	
	return new BusAlgorithmMException("ERROR! Please, contact the developers at <edigley at gmail dot com> and <jaindsonvs at gmail dot com>.\nAlso, don't forget to send the parameters you have used to us.");
    }
}
