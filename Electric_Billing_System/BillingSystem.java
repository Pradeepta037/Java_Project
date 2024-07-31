import java.util.Scanner;

public class BillingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter customer type (Residential/Commercial): ");
        String type = scanner.nextLine();
        
        System.out.println("Enter customer name: ");
        String name = scanner.nextLine();
        
        System.out.println("Enter units consumed: ");
        int units = scanner.nextInt();

        Customer customer;
        if (type.equalsIgnoreCase("Residential")) {
            customer = new ResidentialCustomer(name, units);
        } else if (type.equalsIgnoreCase("Commercial")) {
            customer = new CommercialCustomer(name, units);
        } else {
            System.out.println("Invalid customer type.");
            return;
        }

        double billAmount = customer.calculateBill();
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Units Consumed: " + customer.getUnitsConsumed());
        System.out.println("Total Bill: $" + billAmount);

        scanner.close();
    }
}
