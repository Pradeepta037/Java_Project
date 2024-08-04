public class PaySlip {
    private Employee employee;
    private double grossSalary;
    private double netSalary;

    public PaySlip(Employee employee, double grossSalary, double netSalary) {
        this.employee = employee;
        this.grossSalary = grossSalary;
        this.netSalary = netSalary;
    }

    @Override
    public String toString() {
        return "Pay Slip\n" +
               "Employee: " + employee.getName() + "\n" +
               "ID: " + employee.getId() + "\n" +
               "Gross Salary: $" + grossSalary + "\n" +
               "Net Salary: $" + netSalary + "\n";
    }
}
