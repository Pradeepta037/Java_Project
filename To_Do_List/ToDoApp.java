import java.time.LocalDate;
import java.util.Scanner;

public class ToDoApp {
    private TaskManager taskManager;
    private Scanner scanner;

    public ToDoApp() {
        taskManager = new TaskManager();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Edit Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Mark Task as Complete");
            System.out.println("5. List Tasks");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    addTask();
                    break;
                case 2:
                    editTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    markTaskAsComplete();
                    break;
                case 5:
                    taskManager.listTasks();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void addTask() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter deadline (YYYY-MM-DD): ");
        LocalDate deadline = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        taskManager.addTask(title, description, deadline, category);
    }

    private void editTask() {
        System.out.print("Enter title of task to edit: ");
        String title = scanner.nextLine();
        System.out.print("Enter new description: ");
        String newDescription = scanner.nextLine();
        System.out.print("Enter new deadline (YYYY-MM-DD): ");
        LocalDate newDeadline = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter new category: ");
        String newCategory = scanner.nextLine();
        taskManager.editTask(title, newDescription, newDeadline, newCategory);
    }

    private void deleteTask() {
        System.out.print("Enter title of task to delete: ");
        String title = scanner.nextLine();
        taskManager.deleteTask(title);
    }

    private void markTaskAsComplete() {
        System.out.print("Enter title of task to mark as complete: ");
        String title = scanner.nextLine();
        taskManager.markTaskAsComplete(title);
    }

    public static void main(String[] args) {
        ToDoApp app = new ToDoApp();
        app.start();
    }
}
