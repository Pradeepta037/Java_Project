public class AdvancedOperations extends Operation {
    @Override
    public double perform(double num1, double num2) {
        return Math.sqrt(num1); // Only num1 is used for square root
    }
}
