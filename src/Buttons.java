import javax.swing.*;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons extends JButton {


    //final button size
    private final int height = 50;
    private final int width = 100;

    // always same Layout in constructor
    public Buttons(){
        this.setSize(width, height);


    }
    // getters
    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }




}
