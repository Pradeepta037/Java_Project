public class Logarithm extends Operation {
    @Override
    public double perform(double value, double base) {
        if (base <= 1 || base == 0) {
            throw new IllegalArgumentException("Base must be greater than 1 and not equal to 0");
        }
        return Math.log(value) / Math.log(base);
    }
}
