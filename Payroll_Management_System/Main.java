import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Payroll payroll = new Payroll();

        // Create default dummy employees
        Employee[] employees = {
            new Employee("John Doe", "E001", 5000),
            new Employee("Jane Smith", "E002", 6000)
        };

        // Display default employees and their pay slips
        System.out.println("Default Employees:");
        for (Employee emp : employees) {
            PaySlip paySlip = payroll.generatePaySlip(emp);
            System.out.println(paySlip);
        }

        // User input for new employee
        System.out.println("Enter details for a new employee:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Base Salary: ");
        double baseSalary = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        // Create new employee with user input
        Employee newEmployee = new Employee(name, id, baseSalary);

        // Generate and display pay slip for new employee
        PaySlip newPaySlip = payroll.generatePaySlip(newEmployee);
        System.out.println("\nPay Slip for New Employee:");
        System.out.println(newPaySlip);

        scanner.close();
    }
}
