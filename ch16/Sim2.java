import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Example simulation of animated objects.
 */
public class Sim2 {

    /**
     * Test program that draws a few polygons.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // create some regular polygons
        BlinkingPolygon bp = new BlinkingPolygon(3, 20, Color.BLUE);
        MovingPolygon mp = new MovingPolygon(8, 30);
        RotatingPolygon rp = new RotatingPolygon(5, 40);

        // move them out of the corner
        bp.translate(50, 50);
        mp.translate(100, 100);
        rp.translate(200, 200);

        // create drawing, add polygons
        Drawing drawing = new Drawing(800, 600);
        drawing.add(bp);
        drawing.add(mp);
        drawing.add(rp);

        // set up the window frame
        JFrame frame = new JFrame("Drawing with Thread.sleep");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(drawing);
        frame.pack();
        frame.setVisible(true);

        // main simulation loop
        Toolkit toolkit = frame.getToolkit();
        while (true) {

            // update the drawing
            toolkit.sync();
            drawing.step();

            // delay the simulation
            try {
                Thread.sleep(1000 / 30);
            } catch (InterruptedException e) {
                // do nothing
            }
        }
    }

}
