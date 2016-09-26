package tul.ssv;

import tul.ssv.draw.DrawHolder;
import tul.ssv.draw.Rectangle;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import tul.ssv.draw.GravityRectangle;
import tul.ssv.listeners.CreateNewRectangleListener;

public class GUI_Program extends JFrame {

    public final int FPS = 30;
    public java.util.List<Rectangle> items = new ArrayList<>();

    public final ControlPanel controlPanel = new ControlPanel();
    public final DrawHolder drawHolder = new DrawHolder();

    public static void main(String[] args) {
        new GUI_Program();
    }

    public GUI_Program() throws HeadlessException {

        this.setTitle("GUI aplikace");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new BorderLayout());

        Container container = getContentPane();
        container.add(controlPanel, BorderLayout.WEST);
        container.add(drawHolder, BorderLayout.CENTER);

        this.controlPanel.RAdd_button.addActionListener(
                new CreateNewRectangleListener(this, Color.RED, 1, false)
        );
        this.controlPanel.GAdd_button.addActionListener(
                new CreateNewRectangleListener(this, Color.GREEN, 1, false)
        );
        this.controlPanel.YAdd_button.addActionListener(
                new CreateNewRectangleListener(this, Color.YELLOW, 1, false)
        );
        this.controlPanel.xRAdd_button.addActionListener(
            new CreateNewRectangleListener(this, Color.RED, 1, true)
        );
        this.controlPanel.xGAdd_button.addActionListener(
                new CreateNewRectangleListener(this, Color.GREEN, 1, true)
        );
        this.controlPanel.xYAdd_button.addActionListener(
                new CreateNewRectangleListener(this, Color.YELLOW, 1, true)
        );


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

    public Color getColor() {
        return Color.RED;
    }

    public double getGravity() {
        return 0.5;
    }
}
