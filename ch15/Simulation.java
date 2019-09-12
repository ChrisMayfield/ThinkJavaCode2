import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Application that simulates a cellular automaton.
 */
public class Simulation {

    /**
     * Sets up the grid, creates the frame, and plays the game.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        String title = "Conway's Game of Life";
        Automaton game = new Conway("bakersdozen.cells");

        // String title = "Langton's Ant";
        // Automaton game = new Langton();

        // set up the window frame
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(game.getGrid());
        frame.pack();
        frame.setVisible(true);

        // main simulation loop
        Toolkit toolkit = frame.getToolkit();
        while (true) {

            // update the drawing
            toolkit.sync();
            game.update();

            // delay the simulation
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // do nothing
            }
        }
    }

}
