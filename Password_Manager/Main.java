import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PasswordManager manager = new PasswordManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Password Manager");

        while (true) {
            System.out.println("1. Generate and Add Password");
            System.out.println("2. List Passwords");
            System.out.println("3. Get Password by Index");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter password length:");
                    int length = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    String newPassword = PasswordGenerator.generatePassword(length);
                    manager.addPassword(newPassword);
                    System.out.println("Generated and added new password: " + newPassword);
                    break;

                case 2:
                    manager.listPasswords();
                    break;

                case 3:
                    System.out.println("Enter index of password:");
                    int index = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    String password = manager.getPassword(index);
                    if (password != null) {
                        System.out.println("Password at index " + index + ": " + password);
                    } else {
                        System.out.println("No password found at this index.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
