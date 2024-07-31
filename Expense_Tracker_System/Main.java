// package expenseTracker;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseTracker tracker = new ExpenseTracker(100); // Set capacity to 100 for example

        while (true) {
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Total Expenses");
            System.out.println("4. View Expenses by Category");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter expense name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();

                    System.out.print("Enter date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(scanner.next());

                    System.out.print("Enter category name: ");
                    scanner.nextLine();  // Consume newline
                    String categoryName = scanner.nextLine();
                    Category category = new Category(categoryName);

                    Expense expense = new Expense(name, amount, date, category);
                    tracker.addExpense(expense);
                    System.out.println("Expense added successfully!");
                    break;

                case 2:
                    System.out.println("All Expenses:");
                    for (Expense exp : tracker.getAllExpenses()) {
                        System.out.println(exp);
                    }
                    break;

                case 3:
                    System.out.printf("Total Expenses: %.2f\n", tracker.getTotalExpenses());
                    break;

                case 4:
                    System.out.print("Enter category name: ");
                    String catName = scanner.nextLine();
                    Category cat = new Category(catName);
                    System.out.printf("Total expenses in '%s': %.2f\n", catName, tracker.getTotalExpensesByCategory(cat));
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
