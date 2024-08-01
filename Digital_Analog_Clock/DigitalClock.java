import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class DigitalClock extends Clock {
    private JFrame frame;
    private JLabel timeLabel;

    public DigitalClock() {
        frame = new JFrame("Digital Clock");
        timeLabel = new JLabel("", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 48));
        frame.add(timeLabel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
                timeLabel.setText(String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond()));
            }
        });
        timer.start();
    }

    @Override
    public void updateTime() {
        calendar = Calendar.getInstance();
    }
}
