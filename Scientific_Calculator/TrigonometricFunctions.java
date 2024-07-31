public class TrigonometricFunctions extends Operation {
    private int function;

    public TrigonometricFunctions(int function) {
        this.function = function;
    }

    @Override
    public double perform(double angle, double notUsed) {
        switch (function) {
            case 1: // sine
                return Math.sin(Math.toRadians(angle));
            case 2: // cosine
                return Math.cos(Math.toRadians(angle));
            case 3: // tangent
                return Math.tan(Math.toRadians(angle));
            default:
                throw new IllegalArgumentException("Invalid function type");
        }
    }
}
