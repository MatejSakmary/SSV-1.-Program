import javax.swing.*;
import java.awt.*;

public class Main_Frame extends JFrame {
    private ControlPanel controlPanel;
    private Playground playground;

    public Main_Frame(String title){
        super(title);
        //layout manager
        setLayout (new BorderLayout());

        // Components
        controlPanel = new ControlPanel();
        playground = new Playground();

        //content pane
        Container c = getContentPane();

        c.add(controlPanel, BorderLayout.WEST);
        c.add(playground, BorderLayout.CENTER);
    }
}
