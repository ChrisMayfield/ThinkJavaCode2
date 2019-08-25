import javax.swing.JFrame;

/**
 * Example simulation of Conway's Game of Life.
 */
public class Main {

    /**
     * Sets up the drawing, creates the frame, and plays the game.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // set up the grid and initialize cells
        Grid grid = new Grid(30, 25, 20);
        grid.toggle(1, 2);
        grid.toggle(2, 2);
        grid.toggle(3, 2);
        grid.toggle(6, 1);
        grid.toggle(7, 2);
        grid.toggle(7, 3);
        grid.toggle(8, 1);
        grid.toggle(8, 2);

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
