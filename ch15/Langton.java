import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Langton's Ant.
 */
public class Langton {

    private int xpos;
    private int ypos;
    private int head; // 0=North, 1=East, 2=South, 3=West

    /**
     * Sets up the grid, creates the drawing, and plays the game.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        Grid grid = new Grid(30, 25, 20);
        Drawing drawing = new Drawing(grid);

        // set up the window frame
        JFrame frame = new JFrame("Langton's Ant");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(drawing);
        frame.pack();
        frame.setVisible(true);

        // main simulation loop
        Toolkit toolkit = frame.getToolkit();
        while (true) {

            // update the drawing
            drawing.repaint();

            // delay the simulation
            try {
                Thread.sleep(500);
                toolkit.sync();
            } catch (InterruptedException e) {
                // do nothing
            }
        }
    }

}
