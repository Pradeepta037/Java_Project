import java.util.Calendar;

public abstract class Clock {
    protected Calendar calendar;

    public Clock() {
        calendar = Calendar.getInstance();
    }

    public abstract void updateTime();

    public int getHour() {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public int getMinute() {
        return calendar.get(Calendar.MINUTE);
    }

    public int getSecond() {
        return calendar.get(Calendar.SECOND);
    }
}
