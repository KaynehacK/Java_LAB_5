package Fraction;

import Fraction.FractionInterface;

public class Fraction implements FractionInterface {
    private int numerator;
    private int denominator;

    public int getNumerator() {
        return numerator;
    }

    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public void setDenominator(int denominator) {
        if (denominator == 0) {throw new IllegalArgumentException("Знаменатель не может быть равным нулю");}
        this.denominator = denominator;
        simplify();
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {throw new IllegalArgumentException("Знаменатель не может быть равным нулю");}
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    private int nod(int a, int b) {return (b==0) ? a : nod(b, a % b);}

    private void simplify() {
        int nod = nod(numerator, denominator);
        numerator /= nod;
        denominator /= nod;
        if (denominator < 0) {
            this.denominator *= -1;
            this.numerator *= -1;
        }
    }

    @Override
    public double getValue() {
        return (double) numerator / denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fraction other) return numerator == other.numerator && denominator == other.denominator;
        else return false;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }


}
