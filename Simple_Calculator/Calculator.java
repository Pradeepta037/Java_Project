// Calculator class that uses Operation subclasses
class Calculator {
    private Operation operation;

    // Method to perform addition
    public double add(double a, double b) {
        operation = new Addition();
        return operation.calculate(a, b);
    }

    // Method to perform subtraction
    public double subtract(double a, double b) {
        operation = new Subtraction();
        return operation.calculate(a, b);
    }

    // Method to perform multiplication
    public double multiply(double a, double b) {
        operation = new Multiplication();
        return operation.calculate(a, b);
    }

    // Method to perform division
    public double divide(double a, double b) {
        operation = new Division();
        return operation.calculate(a, b);
    }
}
