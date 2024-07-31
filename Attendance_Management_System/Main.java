import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AttendanceManager manager = new AttendanceManager(10); // Setting a max number of students

        // Adding some initial students
        manager.addStudent(new Student("Alice", 1));
        manager.addStudent(new Student("Bob", 2));
        manager.addStudent(new Student("Charlie", 3));

        while (true) {
            System.out.println("\n1. Mark Attendance");
            System.out.println("2. View Attendance");
            System.out.println("3. List Students");
            System.out.println("4. Add New Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID to mark attendance: ");
                    int idToMark = scanner.nextInt();
                    manager.markAttendance(idToMark);
                    break;
                case 2:
                    manager.viewAttendance();
                    break;
                case 3:
                    manager.listStudents();
                    break;
                case 4:
                    // Add new student
                    System.out.print("Enter student name: ");
                    scanner.nextLine(); // Consume newline
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    manager.addStudent(new Student(name, id));
                    System.out.println("Student added successfully.");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
}
