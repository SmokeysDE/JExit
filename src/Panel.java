import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private Buttons[] btn;

    /**
     * modded default constructor
     */
    public Panel() {
        this.setBackground(Color.gray);
        this.setBackground(Color.gray);
    }

    /**
     * custom csr
     * @param width of the panel
     * @param height of the panel
     */
    public Panel(int width, int height){
        this.setSize(width, height);
        this.setBackground(Color.gray);
        this.setBackground(Color.gray);
    }

    /**
     * Buttons
     */
    public void createButtons(){
        // init buttons
        this.btn = new Buttons[6];
        for (int i = 0; i < btn.length; i++) {
            Buttons buttons = new Buttons();
            btn[i] = buttons;
            this.add(buttons);
        }
    }

    /**
     * button getter
     * @param btnNumber array index
     * @return button
     */
    public Buttons getButton(int btnNumber){

        return btn[btnNumber];
    }
}