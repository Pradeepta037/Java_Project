import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library(50, 10); // Library with capacity for 50 books and 10 borrowers

        while (true) {
            System.out.println("\n===================================");
            System.out.println("       Library Management System");
            System.out.println("===================================");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Register Borrower");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Search Book");
            System.out.println("7. Display Library");
            System.out.println("8. Exit");
            System.out.println("===================================");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n--- Add Book ---");
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.println("\n--- Remove Book ---");
                    System.out.print("Enter book title to remove: ");
                    title = scanner.nextLine();
                    library.removeBook(title);
                    System.out.println("Book removed successfully!");
                    break;

                case 3:
                    System.out.println("\n--- Register Borrower ---");
                    System.out.print("Enter borrower's name: ");
                    String name = scanner.nextLine();
                    library.registerBorrower(new Borrower(name));
                    System.out.println("Borrower registered successfully!");
                    break;

                case 4:
                    System.out.println("\n--- Borrow Book ---");
                    System.out.print("Enter book title to borrow: ");
                    title = scanner.nextLine();
                    System.out.print("Enter borrower's name: ");
                    name = scanner.nextLine();
                    library.borrowBook(title, name);
                    break;

                case 5:
                    System.out.println("\n--- Return Book ---");
                    System.out.print("Enter book title to return: ");
                    title = scanner.nextLine();
                    System.out.print("Enter borrower's name: ");
                    name = scanner.nextLine();
                    library.returnBook(title, name);
                    break;

                case 6:
                    System.out.println("\n--- Search Book ---");
                    System.out.print("Enter book title to search: ");
                    title = scanner.nextLine();
                    library.searchBook(title);
                    break;

                case 7:
                    System.out.println("\n--- Display Library ---");
                    System.out.println(library);
                    break;

                case 8:
                    System.out.println("\nExiting... Thank you for using the Library Management System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
