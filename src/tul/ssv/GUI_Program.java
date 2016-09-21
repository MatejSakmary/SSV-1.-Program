package tul.ssv;


import tul.ssv.draw.DrawHolder;
import tul.ssv.draw.Rectangle;
import sun.applet.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import tul.ssv.draw.GravityRectangle;

public class GUI_Program extends JFrame {

    public final int FPS = 30;
    public java.util.List<Rectangle> items = new ArrayList<>();

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
                addDraw(Color.RED, 1.0);
            }
        });

        this.controlPanel.GAdd_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDraw(Color.GREEN, 0.5);
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

    public Rectangle addDraw(Color color, double gravity) {
        Rectangle draw = new GravityRectangle(color, gravity);
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
        for (Rectangle ball : items) {
            ball.update(size.width, size.height);
        }
    }
}
