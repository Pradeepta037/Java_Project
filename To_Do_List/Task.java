import java.time.LocalDate;

public class Task {
    private String title;
    private String description;
    private LocalDate deadline;
    private boolean isComplete;
    private String category;

    public Task(String title, String description, LocalDate deadline, String category) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.category = category;
        this.isComplete = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public String getCategory() {
        return category;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", isComplete=" + isComplete +
                ", category='" + category + '\'' +
                '}';
    }
}
