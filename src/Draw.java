
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Draw extends JPanel {

    private static final Random random = new Random();
    private final int width, height;
    private int speedX, speedY;
    private final Color color;

    public Draw(Color color) {
        this(random.nextInt(5) + 5,
                random.nextInt(5) + 5,
                color);
    }

    public Draw(int width, int height, Color color) {
        this(width,
                height,
                (random.nextInt(5) + 10) * (random.nextInt(2) * 2 - 1),
                (random.nextInt(5) + 10) * (random.nextInt(2) * 2 - 1),
                color
        );

    }

    public Draw(int width, int height, int speedX, int speedY, Color color) {
        this.height = height;
        this.width = width;
        this.speedX = speedX;
        this.speedY = speedY;
        this.color = color;

        this.setBackground(this.color);
        this.setSize(this.width, this.height);
    }

    public void update(int width, int height) {
        Point p = this.getLocation();
        int nextX = p.x + speedX;
        int nextY = p.y + speedY;

        if (nextX > width - this.width) {
            speedX = -speedX;
            nextX = width - this.width;
        }

        if (nextX < 0) {
            speedX = -speedX;
            nextX = 0;
        }

        if (nextY > height - this.height) {
            speedY = -speedY;
            nextY = height - this.height;
        }

        if (nextY < 0) {
            speedY = -speedY;
            nextY = 0;
        }
        this.setLocation(nextX, nextY);
    }

}
