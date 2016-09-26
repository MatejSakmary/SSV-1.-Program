package tul.ssv.listeners;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tul.ssv.GUI_Program;
import tul.ssv.draw.GravityRectangle;
import tul.ssv.draw.Rectangle;


public class CreateNewRectangleListener implements ActionListener {
    private final GUI_Program program;
    private final Color color;
    private final double gravity;
    public int x;

    public CreateNewRectangleListener(GUI_Program program, Color color, double gravity, boolean multiplier) {
        this.program = program;
        this.color = color;
        this.gravity = gravity;
        if (multiplier == true){
            x = 0;
        }
        else {
            x = 9;
        }

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i= x ; i < 10; i++) {
            Rectangle draw = new GravityRectangle(color, gravity);
            Dimension size = program.drawHolder.getSize();

            draw.setLocation(size.width / 2, size.height / 2);
            program.drawHolder.add(draw);
            program.items.add(draw);
        }
    }
}
