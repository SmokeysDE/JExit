import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private Buttons[] btn;


    public Panel() {
        //this.setSize(height, width);
        this.setBackground(Color.gray);
        this.setBackground(Color.gray);
//        setLayout(new GridLayout(2, 3));
    }
    public Panel(int width, int height){
        this.setSize(width, height);
        this.setBackground(Color.gray);
        this.setBackground(Color.gray);
    }
    public void createButtons(){
        this.btn = new Buttons[6];
        for (int i = 0; i < btn.length; i++) {
            Buttons buttons = new Buttons();
            btn[i] = buttons;
            this.add(buttons);
        }
    }
    public Buttons getButton(int btnNumber){
        return btn[btnNumber];
    }
}

