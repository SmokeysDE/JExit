import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JTimer extends JLabel implements ActionListener {

    private Timer _timer;
    private int remainingTimeInSeconds;
    private String _message;
    private int timer;
    private boolean timerExpired;

    /**
     * Default ctor
     */
    public JTimer() {
        super("00:00", JLabel.RIGHT);
        remainingTimeInSeconds = 0;
        super.setForeground(Color.white);
        super.setSize(200, 200);
        super.setFont(new Font("Sans serif", Font.BOLD, 24));
    }

    public JTimer(String message, int time) {
        super("", JLabel.RIGHT);
        super.setForeground(Color.white);
        super.setSize(200, 200);
        super.setFont(new Font("Sans serif", Font.BOLD, 24));
        this.timer = time;
        remainingTimeInSeconds = time * 60; // 30 minutes in seconds
        this._message = message;
        timerExpired = false;

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
        if (timer > 0) {
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

    public void setTimer(int timer) {
        this.timer = timer;
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
            /**
             * Countdown ist abgelaufen
             */
            if (!timerExpired) {
                setText("00:00");
                JOptionPane.showMessageDialog(null, this._message);
                int informationMessage = JOptionPane.INFORMATION_MESSAGE;
                timerExpired = true;
                _timer.stop(); // stop timer
            }
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