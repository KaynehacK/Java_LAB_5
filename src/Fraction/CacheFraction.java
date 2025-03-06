package Fraction;

public class CacheFraction implements FractionInterface{
    private final FractionInterface fraction;
    private Double cachedValue;

    public CacheFraction(FractionInterface fraction) {this.fraction = fraction;}

    public void invalidateCache() {cachedValue = null;}

    @Override
    public double getValue() {
        if (cachedValue == null) {
            cachedValue = fraction.getValue();
        }
        return cachedValue;
    }

    @Override
    public void setNumerator(int numerator) {
        fraction.setNumerator(numerator);
        invalidateCache();
    }

    @Override
    public void setDenominator(int denominator) {
        fraction.setDenominator(denominator);
        invalidateCache();
    }

    @Override
    public String toString(){
        return fraction.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CacheFraction)) return false;
        return this.fraction.equals(((CacheFraction) obj).fraction);
    }
}
