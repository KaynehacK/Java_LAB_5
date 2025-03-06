package Fraction;

public class InitiateFraction {
    public static FractionInterface createFraction(int numerator, int denominator) {
        return new CacheFraction(new Fraction(numerator, denominator));
    }
}
