import java.awt.Color;
import javax.swing.JFrame;

/**
 * Example simulation of stationary objects.
 */
public class Sim1 {

    /**
     * Test program that draws a few polygons.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // create some regular polygons
        RegularPolygon p3 = new RegularPolygon(3, 50, Color.GREEN);
        RegularPolygon p4 = new RegularPolygon(5, 50, Color.ORANGE);
        RegularPolygon p5 = new RegularPolygon(360, 50, Color.MAGENTA);

        // move them out of the corner
        p3.translate(100, 100);
        p4.translate(250, 250);
        p5.translate(400, 400);

        // create drawing, add polygons
        Drawing drawing = new Drawing(800, 600);
        drawing.add(p3);
        drawing.add(p4);
        drawing.add(p5);

        // set up the window frame
        JFrame frame = new JFrame("Drawing (no animation)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(drawing);
        frame.pack();
        frame.setVisible(true);
    }

}
