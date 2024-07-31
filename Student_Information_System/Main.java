import java.util.Scanner;

public class Main {
    private static final String BORDER = "****************************************";
    private static final String HEADER = "Student Information System";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            printHeader();
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent(scanner, manager);
                    break;
                case 2:
                    updateStudent(scanner, manager);
                    break;
                case 3:
                    deleteStudent(scanner, manager);
                    break;
                case 4:
                    viewStudent(scanner, manager);
                    break;
                case 5:
                    viewAllStudents(manager);
                    break;
                case 6:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printHeader() {
        System.out.println(BORDER);
        System.out.println(HEADER);
        System.out.println(BORDER);
    }

    private static void printMenu() {
        System.out.println("1. Add Student");
        System.out.println("2. Update Student");
        System.out.println("3. Delete Student");
        System.out.println("4. View Student");
        System.out.println("5. View All Students");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addStudent(Scanner scanner, StudentManager manager) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter student grade: ");
        double grade = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Student student = new Student(name, id, grade);
        manager.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void updateStudent(Scanner scanner, StudentManager manager) {
        System.out.print("Enter student ID to update: ");
        int updateId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter new student name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new student grade: ");
        double newGrade = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Student updatedStudent = new Student(newName, updateId, newGrade);
        manager.updateStudent(updateId, updatedStudent);
        System.out.println("Student updated successfully.");
    }

    private static void deleteStudent(Scanner scanner, StudentManager manager) {
        System.out.print("Enter student ID to delete: ");
        int deleteId = scanner.nextInt();
        manager.deleteStudent(deleteId);
        System.out.println("Student deleted successfully.");
    }

    private static void viewStudent(Scanner scanner, StudentManager manager) {
        System.out.print("Enter student ID to view: ");
        int viewId = scanner.nextInt();
        Student viewStudent = manager.getStudent(viewId);
        if (viewStudent != null) {
            System.out.println(viewStudent);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void viewAllStudents(StudentManager manager) {
        System.out.println("All Students:");
        manager.displayAllStudents();
    }
}
