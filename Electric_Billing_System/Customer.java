abstract class Customer {
    protected String name;
    protected int unitsConsumed;

    public Customer(String name, int unitsConsumed) {
        this.name = name;
        this.unitsConsumed = unitsConsumed;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateBill();

    public String getName() {
        return name;
    }

    public int getUnitsConsumed() {
        return unitsConsumed;
    }
}
