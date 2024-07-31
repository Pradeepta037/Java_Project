import java.util.Scanner;

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Create a bank with a capacity for 100 users
        Bank bank = new Bank(100);

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Create Account
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Father's Name: ");
                    String fatherName = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Account Type (saving/current): ");
                    String accountType = scanner.nextLine();
                    System.out.print("Enter Aadhaar No.: ");
                    String aadhaarNo = scanner.nextLine();
                    System.out.print("Enter Mobile No.: ");
                    String mobileNo = scanner.nextLine();
                    System.out.print("Enter PIN: ");
                    int pin = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    bank.createAccount(name, fatherName, age, accountType, aadhaarNo, mobileNo, pin);
                    break;

                case 2: // Login
                    System.out.print("Enter Aadhaar No.: ");
                    String loginAadhaarNo = scanner.nextLine();
                    System.out.print("Enter PIN: ");
                    int loginPin = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    User user = bank.authenticate(loginAadhaarNo, loginPin);
                    if (user != null) {
                        while (true) {
                            System.out.println("\n1. Deposit Money");
                            System.out.println("2. Withdraw Money");
                            System.out.println("3. Check Balance");
                            System.out.println("4. Logout");
                            System.out.print("Enter your choice: ");
                            int action = scanner.nextInt();
                            scanner.nextLine(); // Consume newline

                            switch (action) {
                                case 1: // Deposit Money
                                    System.out.print("Enter amount to deposit: ");
                                    double depositAmount = scanner.nextDouble();
                                    scanner.nextLine(); // Consume newline
                                    user.deposit(depositAmount);
                                    break;

                                case 2: // Withdraw Money
                                    System.out.print("Enter amount to withdraw: ");
                                    double withdrawAmount = scanner.nextDouble();
                                    scanner.nextLine(); // Consume newline
                                    user.withdraw(withdrawAmount);
                                    break;

                                case 3: // Check Balance
                                    user.displayInfo();
                                    break;

                                case 4: // Logout
                                    System.out.println("Logged out successfully.");
                                    return;

                                default:
                                    System.out.println("Invalid choice. Try again.");
                            }
                        }
                    }
                    break;

                case 3: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
