import java.time.LocalDate;
// import java.util.Optional;  //used to avoid null references and can help in reducing NullPointerException.

public class TaskManager {
    private Task[] tasks;
    private int taskCount;
    private static final int MAX_TASKS = 100; // Maximum number of tasks

    public TaskManager() {
        tasks = new Task[MAX_TASKS];
        taskCount = 0;
    }

    public void addTask(String title, String description, LocalDate deadline, String category) {
        if (taskCount < MAX_TASKS) {
            Task task = new Task(title, description, deadline, category);
            tasks[taskCount++] = task;
        } else {
            System.out.println("Task list is full. Cannot add more tasks.");
        }
    }

    public void editTask(String title, String newDescription, LocalDate newDeadline, String newCategory) {
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getTitle().equals(title)) {
                Task updatedTask = new Task(title, newDescription, newDeadline, newCategory);
                tasks[i] = updatedTask;
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void deleteTask(String title) {
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getTitle().equals(title)) {
                for (int j = i; j < taskCount - 1; j++) {
                    tasks[j] = tasks[j + 1];
                }
                tasks[--taskCount] = null; // Remove reference to the last task
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void markTaskAsComplete(String title) {
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getTitle().equals(title)) {
                tasks[i].setComplete(true);
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void listTasks() {
        if (taskCount == 0) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < taskCount; i++) {
                System.out.println(tasks[i]);
            }
        }
    }
}
