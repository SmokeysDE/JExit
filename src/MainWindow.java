import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.text.Position;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.util.EventListener;

public class MainWindow extends JFrame {
    TextField textField = new TextField();
    JLabel label = new JLabel();

    //                      0                       1                       2              3
    String[] command = {"shutdown -s -t 1800","ipconfig -release", "ipconfig -renew", "shutdown -a"};
    GridLayout grid = new GridLayout(2,1,0,0);



    public MainWindow(){
    //Create main Window
        setResizable(false);
        setTitle("Jexit");
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

        Buttons btn = pane.getButton(0);
        Buttons btn1 = pane.getButton(1);
        Buttons btn2 = pane.getButton(2);
        Buttons btn3 = pane.getButton(3);
        Buttons btn4 = pane.getButton(4);
        Buttons btn5 = pane.getButton(5);
        btn.setText("Shutdown");
        btn1.setText("Pomodoro");
        btn2.setText("IP release");
        btn3.setText("Abort");
        btn4.setText("Reminder");
        btn5.setText("IP renew");

    // Button Shutdown
        btn.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                Runtime rt = Runtime.getRuntime();
                try {
                    rt.exec(command[0]); // shutdown -s -t 1800
                    //infoBox("Shutdown in 30 min",btn.getText());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        });
    // Button Pomodoro
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Hallo");
                label.setForeground(Color.white);


            }
        });
    // Button IP release
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runtime rt = Runtime.getRuntime();
                infoBox("Disconnected",btn2.getText());
                try {
                    rt.exec(command[1]);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        // Button Shutdown Abort
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runtime rt = Runtime.getRuntime();
                try{
                    rt.exec(command[3]); // shutdown -a
                } catch(IOException ex){
                    ex.printStackTrace();
                }

            }
        });
        // Button Reminder
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Reminder");
                label.setForeground(Color.white);
            }
        });
        // Button IP Renew
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runtime rt = Runtime.getRuntime();
                infoBox("Reconnect",btn5.getText());
                try{
                    rt.exec(command[2]); // ipconfig -renew
                } catch(IOException ex){
                    ex.printStackTrace();
                }
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
