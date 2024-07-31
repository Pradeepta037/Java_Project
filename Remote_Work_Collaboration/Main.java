// Main.java
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Virtual Whiteboard
        VirtualWhiteboard whiteboard = new VirtualWhiteboard();
        whiteboard.draw("Circle");
        whiteboard.draw("Square");
        whiteboard.display();

        // Project Tracking
        Project project = new Project("Website Redesign");
        project.addTask(new Task("Create mockups"));
        project.addTask(new Task("Develop frontend"));
        project.displayTasks();
        
        // Mark a task as completed
        Task firstTask = project.getTasks()[0];
        if (firstTask != null) {
            firstTask.markAsCompleted();
        }
        project.displayTasks();

        // Meeting Scheduling
        MeetingScheduler scheduler = new MeetingScheduler();
        scheduler.scheduleMeeting(new Meeting("Sprint Planning", LocalDateTime.of(2024, 8, 5, 10, 0)));
        scheduler.scheduleMeeting(new Meeting("Design Review", LocalDateTime.of(2024, 8, 6, 14, 0)));
        scheduler.displayMeetings();
    }
}
