import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Application that simulates a zero-player game.
 */
public class Simulation {

    /**
     * Sets up the grid, creates the frame, and plays the game.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // String title = "Langton's Ant";
        // Automaton auto = new Langton();

        String title = "Conway's Game of Life";
        Automaton auto = new Conway("bakersdozen.cells");

        // set up the window frame
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(auto.getGrid());
        frame.pack();
        frame.setVisible(true);

        // main simulation loop
        Toolkit toolkit = frame.getToolkit();
        while (true) {

            // update the drawing
            toolkit.sync();
            auto.update();

            // delay the simulation
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // do nothing
            }
        }
    }

}
