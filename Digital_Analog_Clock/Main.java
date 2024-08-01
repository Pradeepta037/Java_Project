import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DigitalClock();  // Create and display the digital clock
            new AnalogClock();   // Create and display the analog clock
        });
    }
}
