import javax.swing.*;
import java.awt.*;


public class ControlPanel extends JPanel{
    public ControlPanel() {
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Controls"));

        JButton add_button = new JButton("Add");
        JButton Clear_button = new JButton("Clear");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
    }
}
