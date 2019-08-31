import javax.swing.JFrame;

/**
 * Example simulation of stationary objects.
 */
public class Sim3 {

    /**
     * Test program that draws a few polygons.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        MovingPolygon mp = new MovingPolygon(8, 30);
        mp.translate(100, 100);
        Drawing drawing = new Drawing(800, 600);
        drawing.add(mp);

        JFrame frame = new JFrame("Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(drawing);
        frame.pack();
        frame.setVisible(true);

        // main simulation loop
        while (true) {

            // update the drawing
            drawing.nextact();
            drawing.repaint();

            // delay the simulation
            try {
                Thread.sleep(1000 / 50);
                frame.getToolkit().sync();
            } catch (InterruptedException e) {
                // do nothing
            }
        }
    }

}
