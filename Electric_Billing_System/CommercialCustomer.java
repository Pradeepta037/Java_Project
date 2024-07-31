class CommercialCustomer extends Customer {
    private static final double RATE_PER_UNIT = 10.0;

    public CommercialCustomer(String name, int unitsConsumed) {
        super(name, unitsConsumed);
    }

    @Override
    public double calculateBill() {
        return unitsConsumed * RATE_PER_UNIT;
    }
}
