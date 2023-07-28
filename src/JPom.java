import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JPom extends JLabel implements ActionListener {

    private Timer _timer;
    private int remainingTimeInSeconds;
    private int pomodoroDuration;
    private int shortBreakDuration;
    private int longBreakDuration;
    private int completedPomodoros;
    private boolean isBreak;

    /**
     * Default constructor
     */
    public JPom() {
        super("00:00", JLabel.RIGHT);
        remainingTimeInSeconds = 0;
        super.setForeground(Color.white);
        super.setSize(200, 200);
        super.setFont(new Font("Sans serif", Font.BOLD, 24));
    }

    public JPom(int pomodoroDuration, int shortBreakDuration, int longBreakDuration) {
        super("00:00", JLabel.RIGHT);
        super.setForeground(Color.white);
        super.setSize(200, 200);
        super.setFont(new Font("Sans serif", Font.BOLD, 24));

        this.pomodoroDuration = pomodoroDuration;
        this.shortBreakDuration = shortBreakDuration;
        this.longBreakDuration = longBreakDuration;
        this.completedPomodoros = 0;
        this.isBreak = false;
        this.remainingTimeInSeconds = pomodoroDuration * 60; // Start with the Pomodoro session

        // Initialize the timer but do not start it yet
        _timer = new javax.swing.Timer(1000, this);
    }

    /**
     * Add component to its parent. Start the timer for auto-update.
     */
    @Override
    public void addNotify() {
        super.addNotify();

        // Start the timer only if the initial time is greater than 0
        if (remainingTimeInSeconds > 0) {
            _timer.start();
            updateTimerDisplay(); // Update the display immediately after starting
        }
    }

    /**
     * Remove component from its parent, stop the timer
     */
    @Override
    public void removeNotify() {
        super.removeNotify();
        if (_timer != null) {
            _timer.stop();
            _timer = null;
        }
    }

    /**
     * Start the Pomodoro timer.
     */
    public void startPomodoro() {
        if (isBreak == true) {
            JOptionPane.showMessageDialog(null, "Pause", "Meldung",
                    JOptionPane.INFORMATION_MESSAGE);
            completedPomodoros++;
            if (completedPomodoros % 4 == 0 && completedPomodoros > 0) {
                JOptionPane.showMessageDialog(null, "4 Pomodoros", "Meldung",
                        JOptionPane.INFORMATION_MESSAGE);
                remainingTimeInSeconds = longBreakDuration * 60;
            } else {
                remainingTimeInSeconds = shortBreakDuration * 60;
            }
        } else {
            remainingTimeInSeconds = pomodoroDuration * 60;
        }

        isBreak = !isBreak; // Toggle between Pomodoro and break
        _timer.start();
        updateTimerDisplay();
    }

    /**
     * Stop the Pomodoro timer.
     */
    public void stopPomodoro() {
        _timer.stop();
    }

    /**
     * Update component with the current time.
     *
     * @param e The current event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (remainingTimeInSeconds > 0) {
            remainingTimeInSeconds--;
            updateTimerDisplay();
        } else {
            startPomodoro(); // Start the next pomodoro or break
        }
    }

    /**
     * Update the timer display based on the remaining time.
     */
    private void updateTimerDisplay() {
        int minutes = remainingTimeInSeconds / 60;
        int seconds = remainingTimeInSeconds % 60;
        String countdownText = String.format("%02d:%02d", minutes, seconds);
        setText(countdownText); // set Countdown on Label
    }
}