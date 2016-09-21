package tul.ssv.listeners;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tul.ssv.GUI_Program;
import tul.ssv.draw.GravityRectangle;
import tul.ssv.draw.Rectangle;

/**
 *
 * @author jan-hybs
 */
public class CreateNewRectangleListener implements ActionListener {
    private final GUI_Program program;
    private final Color color;
    private final double gravity;

    public CreateNewRectangleListener(GUI_Program program, Color color, double gravity) {
        this.program = program;
        this.color = color;
        this.gravity = gravity;
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        //Rectangle draw = new GravityRectangle(program.getColor(), program.getGravity());
        Rectangle draw = new GravityRectangle(color, gravity);
        Dimension size = program.drawHolder.getSize();

        draw.setLocation(size.width / 2, size.height / 2);
        program.drawHolder.add(draw);
        program.items.add(draw);
    }
    
}
