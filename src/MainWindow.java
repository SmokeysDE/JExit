import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.io.IOException;


public class MainWindow extends JFrame {

    private JLabel _label = new JLabel();

    /**
     *                           [0]                  [1]                  [2]              [3]
     */

    private String[] _command = {"shutdown -s -t 1800","ipconfig -release", "ipconfig -renew", "shutdown -a"};
    private GridLayout _grid = new GridLayout(2,1,0,0);



    public MainWindow(){

        /**
         * Create main Window
         */
        setResizable(false);
        setTitle("JExit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 500);
        setLocationRelativeTo(null);

        /**
         * Main panel
         */
        Panel panel = new Panel();
        panel.setSize(300,600);
        panel.setLayout(new GridLayout(3,1));

        /**
         * Button Panel
         */
        Panel pane = new Panel();
        pane.setLayout(_grid);
        pane.setSize(300,200);

        /**
         * Mid Panel
         */
        Panel pane2 = new Panel();
        pane2.setSize(300,200);
        pane2.setBackground(Color.darkGray);
        TimePanel time = new TimePanel();
        time.setForeground(Color.white);
        time.setSize(200,200);
        time.setFont(new Font("Sans serif", Font.BOLD, 24));
        JTimer countdown = new JTimer();
        countdown.setForeground(Color.white);
        countdown.setSize(200,200);
        countdown.setFont(new Font("Sans serif", Font.BOLD, 24));
        pane2.setLayout(new GridLayout(1,2));

        /**
         * Low Panel
         */
        Panel pane3 = new Panel();
        pane3.setSize(300,200);

        /**
         *Adding details
         */
        pane2.add(time);
        pane2.add(countdown);
        pane.setBackground(Color.darkGray);
        pane.createButtons();

        /**
         * Button Names and Text
         */
        Buttons shutdown = pane.getButton(0);
        Buttons pomodoro = pane.getButton(1);
        Buttons iprelease = pane.getButton(2);
        Buttons abort = pane.getButton(3);
        Buttons reminder = pane.getButton(4);
        Buttons reconnect = pane.getButton(5);
        shutdown.setText("Shutdown");
        pomodoro.setText("Pomodoro");
        iprelease.setText("IP release");
        abort.setText("Abort");
        reminder.setText("Reminder");
        reconnect.setText("IP renew");

        /**
         * Button Shutdown
         *          lambda for button action
         */

        shutdown.addActionListener(e -> {
            Runtime rt = Runtime.getRuntime();
            try {
                rt.exec(_command[0]); // shutdown -s -t 1800
                infoBox("Shutdown in 30 min", shutdown.getText());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        /**
         * Button Pomodoro
         */
        pomodoro.addActionListener(e -> {

            _label.setForeground(Color.white);


        });

        /**
         * Button IP release
         *              with lambda
         */
        iprelease.addActionListener(e -> {
            Runtime rt = Runtime.getRuntime();
            infoBox("Disconnected",iprelease.getText());
            try {
                rt.exec(_command[1]);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        /**
         * Button Abort
         *              with lambda
         */
        abort.addActionListener(e -> {
            Runtime rt = Runtime.getRuntime();
            infoBox("Shutdown abgebrochen",abort.getText());
            try{
                rt.exec(_command[3]); // shutdown -a
            } catch(IOException ex){
                ex.printStackTrace();
            }

        });

        /**
         * Button Reminder
         *              with lambda
         */
        reminder.addActionListener(e->{

                _label.setText("Reminder");
                _label.setForeground(Color.white);
                inputBox("Bitte eingeben ", reminder.getText());
        });

        /**
         * Button IP renew
         *              with lambda
         */
        reconnect.addActionListener(e ->  {

                Runtime rt = Runtime.getRuntime();
                infoBox("Reconnect",reconnect.getText());
                try{
                    rt.exec(_command[2]); // ipconfig -renew
                } catch(IOException ex) {
                    ex.printStackTrace();
                }
        });

        /**
         * Adding all together
         */
        panel.add(pane);
        panel.add(pane2);
        panel.add(pane3);
        add(panel);
        /**
         * last but not least
         */
        setVisible(true);
        /**
         * It's a kind of magic
         */

    }

    /**
     * custom infoBox for buttons
     * @param infoMessage
     * @param titleBar
     */
    public void infoBox(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar,
                JOptionPane.INFORMATION_MESSAGE);
    }
    public void inputBox(String infoMessage, String titleBar){
        JTextField time = new JTextField();
        JTextField message = new JTextField();
        Object[] input = {
                "Set Timer", time,
                "Message", message
        };

        int option = JOptionPane.showConfirmDialog(null, input, titleBar, JOptionPane.OK_CANCEL_OPTION);
        //if (option == JOptionPane.OK_OPTION) {}

    }
}
