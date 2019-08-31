import javax.swing.JFrame;

/**
 * Example simulation of rotating objects.
 */
public class Sim2 {

    /**
     * Sets up the drawing, creates the actors, and runs the simulation.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // set up the drawing and add actors
        Drawing drawing = new Drawing(800, 600);
        drawing.add(new Triangle(25, 25, 25, 325, 425, 25));
        drawing.add(new Triangle(500, 400, 530, 400, 500, 440));

        // set up the window frame
        JFrame frame = new JFrame("Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // do nothing
            }
        }
    }

}
