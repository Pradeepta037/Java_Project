import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Calendar;

public class AnalogClock extends Clock {
    private JFrame frame;
    private ClockPanel clockPanel;

    public AnalogClock() {
        frame = new JFrame("Analog Clock");
        clockPanel = new ClockPanel();
        frame.add(clockPanel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Timer timer = new Timer(1000, e -> {
            updateTime();
            clockPanel.repaint();
        });
        timer.start();
    }

    @Override
    public void updateTime() {
        calendar = Calendar.getInstance();
    }

    class ClockPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();
            int centerX = width / 2;
            int centerY = height / 2;
            int radius = Math.min(width, height) / 2 - 10;

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Draw clock face
            g2d.setColor(Color.WHITE);
            g2d.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
            g2d.setColor(Color.BLACK);
            g2d.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

            // Draw hour, minute, and second hands
            g2d.setStroke(new BasicStroke(4));
            double hourAngle = Math.toRadians(90 - (getHour() % 12) * 30 - getMinute() * 0.5);
            double minuteAngle = Math.toRadians(90 - getMinute() * 6 - getSecond() * 0.1);
            double secondAngle = Math.toRadians(90 - getSecond() * 6);

            // Hour hand
            g2d.setColor(Color.BLACK);
            g2d.drawLine(centerX, centerY,
                    (int) (centerX + radius * 0.5 * Math.cos(hourAngle)),
                    (int) (centerY - radius * 0.5 * Math.sin(hourAngle)));

            // Minute hand
            g2d.setColor(Color.BLUE);
            g2d.drawLine(centerX, centerY,
                    (int) (centerX + radius * 0.8 * Math.cos(minuteAngle)),
                    (int) (centerY - radius * 0.8 * Math.sin(minuteAngle)));

            // Second hand
            g2d.setColor(Color.RED);
            g2d.drawLine(centerX, centerY,
                    (int) (centerX + radius * 0.9 * Math.cos(secondAngle)),
                    (int) (centerY - radius * 0.9 * Math.sin(secondAngle)));
        }
    }
}
