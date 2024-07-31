// Customer.java
public class Customer {
    private String name;
    private double amount;

    // Constructor
    public Customer(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    // Getter for amount
    public double getAmount() {
        return amount;
    }

    // Setter for amount
    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }
}
