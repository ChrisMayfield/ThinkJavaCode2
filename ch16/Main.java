import javax.swing.JFrame;

/**
 * Example simulation of moving objects.
 */
public class Main {

    /**
     * Sets up the drawing, creates the actors, and runs the simulation.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // set up the grid and initialize cells
        Grid grid = new Grid(30, 25, 20);
        grid.flip(1, 2);
        grid.flip(2, 2);
        grid.flip(3, 2);
        grid.flip(6, 1);
        grid.flip(7, 2);
        grid.flip(7, 3);
        grid.flip(8, 1);
        grid.flip(8, 2);

        // set up the window frame
        JFrame frame = new JFrame("Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(grid);
        frame.pack();
        frame.setVisible(true);

        // main simulation loop
        while (true) {

            // update the drawing
            grid.playGame();
            grid.repaint();

            // delay the simulation
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // do nothing
            }
        }
    }

}
