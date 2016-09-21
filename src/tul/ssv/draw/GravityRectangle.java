package tul.ssv.draw;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author jan-hybs
 */
public class GravityRectangle extends Rectangle {
    
    private final double gravity;

    //private double gravity = 0;
    public GravityRectangle(Color color, double gravity) {
        super(10,
                10,
                (random.nextInt(5) + 10) * (random.nextInt(2) * 2 - 1),
                (random.nextInt(5) + 10) * -1,
                color
        );
        this.gravity = gravity;
    }

    @Override
    protected int updateY(int width, int height) {
        Point p = this.getLocation();
        speedY += gravity;
        int nextY = p.y + (int) speedY;

        if (nextY > height - this.height) {
            speedY *= -1;
            speedY *= 0.8;
            speedX *= 0.8;
            nextY = height - this.height;
        }

        if (nextY < 0) {
            speedY *= -1;
            speedY *= 0.8;
            speedX *= 0.8;
            nextY = 0;
        }

        return nextY;
    }
    
    @Override
    protected int updateX(int width, int height) {
        Point p = this.getLocation();
        //speedX += gravity;
        int nextX = p.x + (int) speedX;

        if (nextX > width - this.width) {
            speedX *= -1;
            speedX *= 0.8;
            nextX = width - this.width;
        }

        if (nextX < 0) {
            speedX *= -1;
            speedX *= 0.8;
            nextX = 0;
        }

        return nextX;
    }

}
