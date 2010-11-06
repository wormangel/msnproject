package util;

import static java.lang.Math.abs;
import static java.lang.Math.signum;

public class Util {

    public static boolean isEqual(double value1, double value2, double tol) {
        return abs(value1 - value2) < tol;
    }

    public static boolean isUnequal(double value1, double value2, double tol) {
        return !isEqual(value1, value2, tol);
    }

    public static boolean sameSigns(double value1, double value2) {
        return signum(value1) == signum(value2);
    }

    public static boolean liesBetween(double value, double lowerBound,
            double upperBound, double tol) {
        return value >= (lowerBound - tol) && value <= (upperBound + tol);
    }

}
