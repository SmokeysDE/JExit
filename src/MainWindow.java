import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.io.IOException;

@SuppressWarnings("ALL")
public class MainWindow extends JFrame {
//    TextField textField = new TextField();
    JLabel label = new JLabel();

    //                         0                       1                    2                3
    String[] command = {"shutdown -s -t 1800","ipconfig -release", "ipconfig -renew", "shutdown -a"};
    GridLayout grid = new GridLayout(2,1,0,0);



    public MainWindow(){
    //Create main Window
        setResizable(false);
        setTitle("JExit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 500);
        setLocationRelativeTo(null);

    //Create first (Main) Panel
        Panel panel = new Panel();
        panel.setSize(300,600);
        panel.setLayout(new GridLayout(3,1));

    // Button Panel
        Panel pane = new Panel();
        pane.setLayout(grid);
        pane.setSize(300,200);

    // Mid Panel
        Panel pane2 = new Panel();
        pane2.setSize(300,200);
        pane2.setBackground(Color.darkGray);

    // Low Panel
        Panel pane3 = new Panel();
        pane3.setSize(300,200);

    // Adding details
        pane2.add(label);
        pane.setBackground(Color.darkGray);
        pane.createButtons();

    //Button Names, Text
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

    // Button Shutdown
        // anonym action-listener for button action
        shutdown.addActionListener(e -> {
            Runtime rt = Runtime.getRuntime();
            try {
                rt.exec(command[0]); // shutdown -s -t 1800
                infoBox("Shutdown in 30 min", shutdown.getText());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    // Button Pomodoro
        pomodoro.addActionListener(e -> {
            label.setText("Hallo");
            label.setForeground(Color.white);


        });
    // Button IP release
        iprelease.addActionListener(e -> {
            Runtime rt = Runtime.getRuntime();
            infoBox("Disconnected",iprelease.getText());
            try {
                rt.exec(command[1]);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        // Button Shutdown Abort
        abort.addActionListener(e -> {
            Runtime rt = Runtime.getRuntime();
            infoBox("Shutdown abgebrochen",abort.getText());
            try{
                rt.exec(command[3]); // shutdown -a
            } catch(IOException ex){
                ex.printStackTrace();
            }

        });
        // Button Reminder
        reminder.addActionListener(e->{

                label.setText("Reminder");
                label.setForeground(Color.white);
        });
        // Button IP Renew
        reconnect.addActionListener(e ->  {

                Runtime rt = Runtime.getRuntime();
                infoBox("Reconnect",reconnect.getText());
                try{
                    rt.exec(command[2]); // ipconfig -renew
                } catch(IOException ex) {
                    ex.printStackTrace();
                }
        });

    // Adding all together
        panel.add(pane);
        panel.add(pane2);
        panel.add(pane3);
        add(panel);
    // last but not least
        setVisible(true);
    // Optional ?
        //pack();
    // Optional ?

    }
    // Model infoBox for buttons
    public void infoBox(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar,
                JOptionPane.INFORMATION_MESSAGE);
    }
}
