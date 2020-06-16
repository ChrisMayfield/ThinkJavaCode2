import java.awt.Color;
import javax.swing.JFrame;

/**
 * Initial drawing of stationary objects.
 */
public class Sim1 {

    /**
     * Test program that draws a few polygons.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // create some regular polygons
        DrawablePolygon p1 = new RegularPolygon(3, 50, Color.GREEN);
        DrawablePolygon p2 = new RegularPolygon(6, 50, Color.ORANGE);
        DrawablePolygon p3 = new RegularPolygon(360, 50, Color.BLUE);

        // move them out of the corner
        p1.translate(100, 80);
        p2.translate(250, 120);
        p3.translate(400, 160);

        // create drawing, add polygons
        Drawing drawing = new Drawing(500, 250);
        drawing.add(p1);
        drawing.add(p2);
        drawing.add(p3);

        // set up the window frame
        JFrame frame = new JFrame("Drawing (no animation)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(drawing);
        frame.pack();
        frame.setVisible(true);
    }

}
