// MeetingScheduler.java
class MeetingScheduler {
    private Meeting[] meetings;
    private int meetingCount;

    public MeetingScheduler() {
        this.meetings = new Meeting[100]; // Assuming a maximum of 100 meetings
        this.meetingCount = 0;
    }

    public void scheduleMeeting(Meeting meeting) {
        if (meetingCount < meetings.length) {
            meetings[meetingCount++] = meeting;
        } else {
            System.out.println("Meeting schedule is full.");
        }
    }

    public void displayMeetings() {
        System.out.println("Scheduled Meetings:");
        for (int i = 0; i < meetingCount; i++) {
            System.out.println(meetings[i]);
        }
    }
}
