package tul.ssv;


import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;

public class ControlPanel extends JPanel {

    public JButton RAdd_button;
    public JButton GAdd_button;
    public JButton YAdd_button;
    public JButton xRAdd_button;
    public JButton xGAdd_button;
    public JButton xYAdd_button;

    public ControlPanel() {
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Controls"));

        JLabel GreenRectangles = new JLabel("Green: ");
        JLabel RedRectangles = new JLabel("Red: ");
        JLabel YellowRectangle = new JLabel("Yellow:");
        JLabel Filler = new JLabel("");

        this.RAdd_button = new JButton("Add");
        this.GAdd_button = new JButton("Add");
        this.YAdd_button = new JButton("Add");
        this.xRAdd_button = new JButton("Add 10x");
        this.xGAdd_button = new JButton("Add 10x");
        this.xYAdd_button = new JButton("Add 10x");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        //// prvni sloupec///////
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 0;
        add(RedRectangles, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(GreenRectangles, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(YellowRectangle, gc);

        //// druhy sloupec///////
        gc.gridx = 1;
        gc.gridy = 0;
        add(GAdd_button, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(RAdd_button, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        add(YAdd_button, gc);

        //// treti sloupec ///
        gc.gridx = 2;
        gc.gridy = 0;
        add(xRAdd_button, gc);

        gc.gridx = 2;
        gc.gridy = 1;
        add(xGAdd_button,gc);

        gc.gridx = 2;
        gc.gridy = 2;
        add(xYAdd_button,gc);

        //// filler ////
        gc.weighty = 10;
        gc.gridx = 1;
        gc.gridy = 3;
        add(Filler, gc);

    }
}
