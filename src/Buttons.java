import javax.swing.JButton;


public class Buttons extends JButton {


    /**
     * final button size
     */

    private final int height = 50;
    private final int width = 100;

    /**
     * always same Layout in constructor
     */
    public Buttons(){
        this.setSize(width, height);


    }

    /**
     * getter
     * @return height
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * getter
     * @return width
     */
    @Override
    public int getWidth() {
        return width;
    }
}