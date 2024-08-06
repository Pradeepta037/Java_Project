import java.util.Scanner;

// Main class to run the calculator application
public class CalculatorApp {
    public static void main(String[] args) {
        // Create an instance of the Calculator class
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter two numbers
        System.out.println("Enter first number:");
        double num1 = scanner.nextDouble();
        
        System.out.println("Enter second number:");
        double num2 = scanner.nextDouble();
        
        // Prompt the user to select an operation
        System.out.println("Select an operation: ");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        
        int choice = scanner.nextInt();
        
        double result = 0;
        boolean validOperation = true;
        
        // Perform the chosen operation
        switch (choice) {
            case 1:
                result = calculator.add(num1, num2);
                System.out.println("Result of Addition: " + result);
                break;
            case 2:
                result = calculator.subtract(num1, num2);
                System.out.println("Result of Subtraction: " + result);
                break;
            case 3:
                result = calculator.multiply(num1, num2);
                System.out.println("Result of Multiplication: " + result);
                break;
            case 4:
                try {
                    result = calculator.divide(num1, num2);
                    System.out.println("Result of Division: " + result);
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                validOperation = false;
                System.out.println("Invalid operation selected.");
                break;
        }
        
        // Close the scanner
        scanner.close();
        
        if (validOperation) {
            System.out.println("Calculation successful!");
        } else {
            System.out.println("Calculation failed due to invalid input.");
        }
    }
}
