import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;


public class JTimer extends JLabel implements ActionListener {

    private Timer _timer;
    private int remainingTimeInSeconds;

    public JTimer(){
        super("",JLabel.RIGHT);
        remainingTimeInSeconds = 30 * 60; // 30 Minuten in Sekunden umrechnen
    }

    @Override
    public void addNotify()
    {
        super.addNotify();
        _timer = new javax.swing.Timer(1000, this);
        _timer.start();
    }

    @Override
    public void removeNotify()
    {
        super.removeNotify();
        if(_timer != null){

            _timer.stop();
            _timer = null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * Countdown function
         */
        if (remainingTimeInSeconds > 0) {
            remainingTimeInSeconds--;
            int minutes = remainingTimeInSeconds / 60;
            int seconds = remainingTimeInSeconds % 60;

            String countdownText = String.format("%02d:%02d", minutes, seconds);
            setText(countdownText); // Label mit dem aktualisierten Countdown-Text setzen
        } else {
            /**
             * Countdown ist abgelaufen
              */
            setText("00:00");
            _timer.stop(); // Timer stoppen, da der Countdown abgelaufen ist
        }
    }
}