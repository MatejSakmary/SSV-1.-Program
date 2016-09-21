
import sun.applet.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class GUI_Program extends JFrame {

    public final int FPS = 30;
    public java.util.List<Draw> items = new ArrayList<>();

    public final ControlPanel controlPanel = new ControlPanel();
    public final DrawHolder drawHolder = new DrawHolder();

    public static void main(String[] args) {
        new GUI_Program(true);
    }

    public GUI_Program(boolean add) throws HeadlessException {

        this.setTitle("GUI aplikace");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new BorderLayout());

        Container container = getContentPane();
        container.add(controlPanel, BorderLayout.WEST);
        container.add(drawHolder, BorderLayout.CENTER);

        this.controlPanel.RAdd_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDraw(Color.RED);
            }
        });

        this.controlPanel.GAdd_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDraw(Color.GREEN);
            }
        });

        while (true) {
            this.repaint();

            try {
                Thread.currentThread().sleep(1000 / FPS);
            } catch (InterruptedException ex) {
            }
        }

    }

    public Draw addDraw(Color color) {
        Draw draw = new Draw(color);
        Dimension size = drawHolder.getSize();

        draw.setLocation(size.width / 2, size.height / 2);
        drawHolder.add(draw);
        items.add(draw);
        return draw;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Dimension size = drawHolder.getSize();
        for (Draw ball : items) {
            ball.update(size.width, size.height);
        }
    }
}
