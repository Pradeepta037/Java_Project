public class Exponentiation extends Operation {
    @Override
    public double perform(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}
