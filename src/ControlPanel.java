import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;



public class ControlPanel extends JPanel{

    public ControlPanel() {
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Controls"));

        JLabel GreenRectangles = new JLabel("Green: ");
        JLabel RedRectangles = new JLabel("Red: ");
        JLabel Filler = new JLabel("");

        JButton RAdd_button = new JButton("Add");
        JButton GAdd_button = new JButton("Add");

        RAdd_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        //// prvni sloupec///////
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 0;
        add(GreenRectangles, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(RedRectangles, gc);

        //// druhy sloupec///////
        gc.gridx = 1;
        gc.gridy = 0;
        add(GAdd_button, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(RAdd_button, gc);

        //// filler ////
        gc.weighty = 10;
        gc.gridx = 1;
        gc.gridy = 2;
        add(Filler, gc);

    }
}
