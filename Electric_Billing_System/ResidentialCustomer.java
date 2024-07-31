class ResidentialCustomer extends Customer {
    private static final double RATE_PER_UNIT = 5.0;

    public ResidentialCustomer(String name, int unitsConsumed) {
        super(name, unitsConsumed);
    }

    @Override
    public double calculateBill() {
        return unitsConsumed * RATE_PER_UNIT;
    }
}
