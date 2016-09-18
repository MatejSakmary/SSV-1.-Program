import javax.swing.*;

public class GUI_Program {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new Main_Frame("GUI aplikace");
                frame.setSize(800, 600);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);


                Draw object = new Draw();
                frame.add(object);
                object.drawing();


            }
        });
    }
}
