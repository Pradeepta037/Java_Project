// package expenseTracker;

import java.time.LocalDate;

public class ExpenseTracker {
    private Expense[] expenses;
    private int count;

    public ExpenseTracker(int capacity) {
        expenses = new Expense[capacity];
        count = 0;
    }

    public void addExpense(Expense expense) {
        if (count < expenses.length) {
            expenses[count++] = expense;
        } else {
            System.out.println("Expense tracker is full.");
        }
    }

    public double getTotalExpenses() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += expenses[i].getAmount();
        }
        return total;
    }

    public double getTotalExpensesByCategory(Category category) {
        double total = 0;
        for (int i = 0; i < count; i++) {
            if (expenses[i].getCategory().equals(category)) {
                total += expenses[i].getAmount();
            }
        }
        return total;
    }

    public Expense[] getExpensesByDate(LocalDate date) {
        Expense[] result = new Expense[count];
        int resultCount = 0;
        for (int i = 0; i < count; i++) {
            if (expenses[i].getDate().equals(date)) {
                result[resultCount++] = expenses[i];
            }
        }
        // Return a new array of exact size
        Expense[] exactResult = new Expense[resultCount];
        System.arraycopy(result, 0, exactResult, 0, resultCount);
        return exactResult;
    }

    public Expense[] getAllExpenses() {
        Expense[] result = new Expense[count];
        System.arraycopy(expenses, 0, result, 0, count);
        return result;
    }
}
