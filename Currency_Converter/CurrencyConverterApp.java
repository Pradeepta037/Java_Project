import java.util.Scanner;

public class CurrencyConverterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        System.out.println("Welcome to the Currency Converter!");

        while (true) {
            System.out.println("\nEnter amount to convert:");
            double amount = scanner.nextDouble();

            System.out.println("Enter the currency to convert from (e.g., USD, EUR):");
            String fromCurrency = scanner.next().toUpperCase();

            System.out.println("Enter the currency to convert to (e.g., USD, EUR):");
            String toCurrency = scanner.next().toUpperCase();

            try {
                double result = converter.convert(amount, fromCurrency, toCurrency);
                System.out.printf("%.2f %s is equal to %.2f %s%n", amount, fromCurrency, result, toCurrency);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Do you want to perform another conversion? (yes/no)");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }
        scanner.close();
    }
}
