// Meeting.java
import java.time.LocalDateTime;

class Meeting {
    private String topic;
    private LocalDateTime dateTime;

    public Meeting(String topic, LocalDateTime dateTime) {
        this.topic = topic;
        this.dateTime = dateTime;
    }

    public String getTopic() {
        return topic;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Meeting on " + dateTime + " about " + topic;
    }
}

