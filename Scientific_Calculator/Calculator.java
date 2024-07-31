import java.util.Scanner;

public class Calculator {
    private Operation operation;
    private double memory = 0;

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public double calculate(double num1, double num2) {
        if (operation != null) {
            return operation.perform(num1, num2);
        }
        throw new IllegalStateException("Operation not set");
    }

    public void setMemory(double value) {
        memory = value;
    }

    public double recallMemory() {
        return memory;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.println("Select operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exponentiation");
        System.out.println("6. Logarithm");
        System.out.println("7. Trigonometric Functions");
        System.out.println("8. Square Root");
        System.out.println("9. Memory Operations");

        int choice = scanner.nextInt();
        double num1 = 0, num2 = 0;

        if (choice != 9) {
            System.out.print("Enter first number: ");
            num1 = scanner.nextDouble();
        }

        if (choice < 8) {
            System.out.print("Enter second number: ");
            num2 = scanner.nextDouble();
        }

        switch (choice) {
            case 1:
                calc.setOperation(new Addition());
                System.out.println("Result: " + calc.calculate(num1, num2));
                break;
            case 2:
                calc.setOperation(new Subtraction());
                System.out.println("Result: " + calc.calculate(num1, num2));
                break;
            case 3:
                calc.setOperation(new Multiplication());
                System.out.println("Result: " + calc.calculate(num1, num2));
                break;
            case 4:
                calc.setOperation(new Division());
                System.out.println("Result: " + calc.calculate(num1, num2));
                break;
            case 5:
                calc.setOperation(new Exponentiation());
                System.out.println("Result: " + calc.calculate(num1, num2));
                break;
            case 6:
                calc.setOperation(new Logarithm());
                System.out.println("Result: " + calc.calculate(num1, num2));
                break;
            case 7:
                System.out.println("Select function: 1. Sine 2. Cosine 3. Tangent");
                int function = scanner.nextInt();
                calc.setOperation(new TrigonometricFunctions(function));
                System.out.println("Result: " + calc.calculate(num1, 0)); // num2 is not used in trigonometric calculations
                break;
            case 8:
                calc.setOperation(new AdvancedOperations());
                System.out.println("Result: " + calc.calculate(num1, 0)); // num2 is not used for square root
                break;
            case 9:
                System.out.println("Select memory operation: 1. Store 2. Recall");
                int memChoice = scanner.nextInt();
                if (memChoice == 1) {
                    System.out.print("Enter value to store in memory: ");
                    double value = scanner.nextDouble();
                    calc.setMemory(value);
                } else if (memChoice == 2) {
                    System.out.println("Memory value: " + calc.recallMemory());
                } else {
                    System.out.println("Invalid choice");
                }
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
