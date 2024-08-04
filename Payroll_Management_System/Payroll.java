public class Payroll {
    private static final double TAX_RATE = 0.10; // Example tax rate
    private static final double OTHER_DEDUCTION = 200; // Example fixed deduction

    public double calculateGrossSalary(Employee employee) {
        return employee.getBaseSalary();
    }

    public double calculateNetSalary(Employee employee) {
        double grossSalary = calculateGrossSalary(employee);
        double tax = grossSalary * TAX_RATE;
        double netSalary = grossSalary - tax - OTHER_DEDUCTION;
        return netSalary;
    }

    public PaySlip generatePaySlip(Employee employee) {
        double grossSalary = calculateGrossSalary(employee);
        double netSalary = calculateNetSalary(employee);
        return new PaySlip(employee, grossSalary, netSalary);
    }
}
