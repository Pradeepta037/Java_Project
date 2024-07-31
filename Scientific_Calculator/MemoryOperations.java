public class MemoryOperations extends Operation {
    private Calculator calc;

    public MemoryOperations(Calculator calc) {
        this.calc = calc;
    }

    @Override
    public double perform(double value, double notUsed) {
        // Memory operation: store or recall
        if (value == -1) {
            return calc.recallMemory();
        } else {
            calc.setMemory(value);
            return value;
        }
    }
}
