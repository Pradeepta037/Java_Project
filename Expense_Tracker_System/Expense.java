// package expenseTracker;

import java.time.LocalDate;

public class Expense {
    private String name;
    private double amount;
    private LocalDate date;
    private Category category;

    public Expense(String name, double amount, LocalDate date, Category category) {
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    @Override
    public String toString() {
        return String.format("Expense{name='%s', amount=%.2f, date=%s, category=%s}",
                name, amount, date, category.getName());
    }
}
