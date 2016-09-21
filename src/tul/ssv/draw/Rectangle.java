package tul.ssv.draw;


import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Rectangle extends JPanel {

    protected static final Random random = new Random();
    protected final int width, height;
    protected double speedX, speedY;
    private final Color color;

    public Rectangle(Color color) {
        this(random.nextInt(5) + 5,
                random.nextInt(5) + 5,
                color);
    }

    public Rectangle(int width, int height, Color color) {
        this(width,
                height,
                (random.nextInt(5) + 10) * (random.nextInt(2) * 2 - 1),
                (random.nextInt(5) + 10) * (random.nextInt(2) * 2 - 1),
                color
        );

    }

    public Rectangle(int width, int height, int speedX, int speedY, Color color) {
        this.height = height;
        this.width = width;
        this.speedX = speedX;
        this.speedY = speedY;
        this.color = color;

        this.setBackground(this.color);
        this.setSize(this.width, this.height);
    }
    
    protected int updateX (int width, int height) {
        Point p = this.getLocation();
        int nextX = p.x + (int)speedX;
        
        if (nextX > width - this.width) {
            speedX = -speedX;
            nextX = width - this.width;
        }

        if (nextX < 0) {
            speedX = -speedX;
            nextX = 0;
        }
        return nextX;
    }
    
    public void update(int width, int height) {
        this.setLocation(
                updateX(width, height),
                updateY(width, height)
        );
    }
    
    protected int updateY(int width, int height) {
        Point p = this.getLocation();
        int nextY = p.y + (int)speedY;


        if (nextY > height - this.height) {
            speedY = -speedY;
            nextY = height - this.height;
        }

        if (nextY < 0) {
            speedY = -speedY;
            nextY = 0;
        }
        return nextY;
    }
    

}
