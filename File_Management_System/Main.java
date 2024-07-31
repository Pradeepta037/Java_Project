import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileManager fileManager = new FileManager("my_files"); // Change the directory path as needed

        while (true) {
            System.out.println("\nFile Management System");
            System.out.println("1. Create File");
            System.out.println("2. Delete File");
            System.out.println("3. Rename File");
            System.out.println("4. Search Files");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter file name to create: ");
                    String createFileName = scanner.nextLine();
                    try {
                        fileManager.createFile(createFileName);
                    } catch (IOException e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter file name to delete: ");
                    String deleteFileName = scanner.nextLine();
                    fileManager.deleteFile(deleteFileName);
                    break;
                case 3:
                    System.out.print("Enter old file name: ");
                    String oldName = scanner.nextLine();
                    System.out.print("Enter new file name: ");
                    String newName = scanner.nextLine();
                    fileManager.renameFile(oldName, newName);
                    break;
                case 4:
                    System.out.print("Enter search keyword: ");
                    String keyword = scanner.nextLine();
                    fileManager.searchFiles(keyword);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
