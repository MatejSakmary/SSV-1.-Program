package tul.ssv;

import javax.swing.*;
import java.awt.*;

public class Main_Frame extends JFrame {
    private ControlPanel controlPanel;

    public Main_Frame(String title){
        super(title);
        //layout manager
        setLayout (new BorderLayout());
        // Components
        controlPanel = new ControlPanel();
        //content pane
        Container c = getContentPane();




    }
}
