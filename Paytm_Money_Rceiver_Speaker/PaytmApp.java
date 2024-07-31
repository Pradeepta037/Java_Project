// PaytmApp.java
import java.util.Scanner;

public class PaytmApp {

    // Convert number to words
    public static String convertNumberToWords(double number) {
        if (number == 0) {
            return "Zero rupees";
        }

        // Split into integer and decimal parts
        long intPart = (long) number;
        int decimalPart = (int) Math.round((number - intPart) * 100);

        StringBuilder words = new StringBuilder();

        // Convert integer part
        if (intPart > 0) {
            words.append(convertToWords(intPart));
        }

        // Append decimal part if it's not zero
        if (decimalPart > 0) {
            if (words.length() > 0) {
                words.append(" and ");
            }
            words.append(convertToWords(decimalPart)).append(" paise");
        }

        words.append(" rupees");

        return words.toString();
    }

    // Convert integer part to words
    private static String convertToWords(long number) {
        if (number == 0) {
            return "Zero";
        }

        String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] thousands = {"", "Thousand", "Million", "Billion"};

        StringBuilder words = new StringBuilder();

        int thousandCounter = 0;
        while (number > 0) {
            int remainder = (int) (number % 1000);
            if (remainder != 0) {
                String tempWords = convertHundreds(remainder, units, teens, tens);
                words.insert(0, tempWords + (thousandCounter > 0 ? thousands[thousandCounter] + " " : ""));
            }
            number /= 1000;
            thousandCounter++;
        }

        return words.toString().trim();
    }

    // Convert hundreds part to words
    private static String convertHundreds(int number, String[] units, String[] teens, String[] tens) {
        StringBuilder words = new StringBuilder();

        if (number % 100 < 20) {
            if (number % 100 < 10) {
                words.append(units[number % 10]);
            } else {
                words.append(teens[number % 100 - 10]);
            }
        } else {
            words.append(tens[number / 10]);
            if (number % 10 > 0) {
                words.append(" ");
                words.append(units[number % 10]);
            }
        }

        number /= 100;
        if (number > 0) {
            words.insert(0, units[number] + " Hundred ");
        }

        return words.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get customer name and amount
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter amount (integer or decimal): ");
        double amount = scanner.nextDouble();

        // Create Customer object
        Customer customer = new Customer(name, amount);

        // Convert amount to words
        String amountInWords = convertNumberToWords(customer.getAmount());

        // Display the result
        System.out.println("The amount in words: " + amountInWords + " received on Paytm.");
        scanner.close();
    }
}
