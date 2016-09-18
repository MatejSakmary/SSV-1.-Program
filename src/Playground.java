import javax.swing.*;
import java.awt.*;


public class Playground extends JPanel{
    public Playground() {
        Dimension size = getPreferredSize();
        size.width = 500;
        setPreferredSize(size);



        setBorder(BorderFactory.createLoweredSoftBevelBorder());

    }
}