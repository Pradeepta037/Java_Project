// Project.java
class Project {
    private String name;
    private Task[] tasks;
    private int taskCount;

    public Project(String name) {
        this.name = name;
        this.tasks = new Task[100]; // Assuming a maximum of 100 tasks
        this.taskCount = 0;
    }

    public void addTask(Task task) {
        if (taskCount < tasks.length) {
            tasks[taskCount++] = task;
        } else {
            System.out.println("Task list is full.");
        }
    }

    public void displayTasks() {
        System.out.println("Tasks for project: " + name);
        for (int i = 0; i < taskCount; i++) {
            System.out.println(tasks[i]);
        }
    }

    public Task[] getTasks() {
        return tasks;
    }
}
