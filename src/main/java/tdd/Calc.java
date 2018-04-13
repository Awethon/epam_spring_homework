package tdd;

public class Calc {
    private static void check(double a, double b) {
        if (Double.isNaN(a) || Double.isNaN(b)) throw new IllegalArgumentException("One of values was NaN");
    }

    public static double multiply(double a, double b) {
        check(a, b);
        return a * b;
    }

    public static double divide(double a, double b) {
        check(a, b);
        return a / b;
    }

    public static double add(double a, double b) {
        check(a, b);
        return a + b;
    }

    public static double subtract(double a, double b) {
        check(a, b);
        return a - b;
    }
}
