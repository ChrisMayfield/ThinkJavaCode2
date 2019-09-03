import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Example simulation of moving objects.
 */
public class Sim2 {

    /**
     * Test program that draws a few polygons.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // create some regular polygons
        MovingPolygon mp = new MovingPolygon(8, 30);
        RotatingPolygon rp = new RotatingPolygon(5, 50);

        // move them out of the corner
        mp.translate(100, 100);
        rp.translate(200, 200);

        // create drawing, add polygons
        Drawing drawing = new Drawing(800, 600);
        drawing.add(mp);
        drawing.add(rp);

        // set up the window frame
        JFrame frame = new JFrame("Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(drawing);
        frame.pack();
        frame.setVisible(true);

        // main simulation loop
        Toolkit toolkit = frame.getToolkit();
        while (true) {

            // update the drawing
            drawing.nextact();
            drawing.repaint();

            // delay the simulation
            try {
                Thread.sleep(1000 / 60);
                toolkit.sync();
            } catch (InterruptedException e) {
                // do nothing
            }
        }
    }

}
