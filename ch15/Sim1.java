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
        RegularPolygon p3 = new RegularPolygon(3, 100);
        RegularPolygon p4 = new RegularPolygon(4, 100);
        RegularPolygon p5 = new RegularPolygon(5, 100);

        // move them out of the corner
        p3.translate(100, 100);
        p4.translate(250, 250);
        p5.translate(400, 400);

        // add polygons to a drawing
        Drawing drawing = new Drawing(800, 600);
        drawing.add(p3);
        drawing.add(p4);
        drawing.add(p5);

        // set up the window frame
        JFrame frame = new JFrame("Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(drawing);
        frame.pack();
        frame.setVisible(true);
    }

}
