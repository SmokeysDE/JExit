import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private Buttons[] btn;


    public Panel() {
        this.setBackground(Color.gray);
        this.setBackground(Color.gray);
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

