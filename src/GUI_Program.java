import sun.applet.Main;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GUI_Program extends JFrame {

    public final int FPS = 30;
    public java.util.List<Draw> items = new ArrayList<>();

    public static void main(String[] args) {
        new Main();
    }
            public GUI_Program(boolean add) throws HeadlessException {
                ControlPanel controlPanel;

                JFrame frame = new JFrame("GUI aplikace");
                frame.setSize(800, 600);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                frame.setLayout(new BorderLayout());
                controlPanel = new ControlPanel();
                Container c = getContentPane();

                c.add(controlPanel, BorderLayout.WEST);
                if (add==true){
                    Draw ball = new Draw(10,10);
                    ball.setLocation(new Random().nextInt(800), new Random().nextInt(600));

                    c.add(ball);

                }
                while (true) {
                    this.repaint();

                    try {
                        Thread.currentThread().sleep(1000/FPS);
                    } catch (InterruptedException ex) {
                    }
                }

            }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Dimension size = this.getSize();
        for (Draw ball : items) {
            ball.update(size.width, size.height-30);
        }
    }
    }
