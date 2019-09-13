import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Application that simulates a cellular automaton.
 */
public class Main {

    /**
     * Creates an automaton and runs it.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        String title = "Conway's Game of Life";
        //Automaton game = new Conway();
        Automaton game = new Conway("pulsar.cells", 2);
        runSimulation(title, game, 500);
    }

    /**
	 * Creates a JFrame and runs the simulation.
	 * 
	 * @param title
	 * @param game
	 * @param delay
	 */
	public static void runSimulation(String title, Automaton game, int delay) {
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
            game.update();
            //toolkit.sync();

            // delay the simulation
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                // do nothing
            }
        }
	}
}
