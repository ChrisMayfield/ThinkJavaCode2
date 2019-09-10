import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Conway's Game of Life.
 */
public class Conway {

    /**
     * Counts the number of live neighbors (without going out of bounds).
     * 
     * @param grid the grid
     * @param r row index
     * @param c column index
     * @return number of live neighbors
     */
    public static int countAlive(Grid grid, int r, int c) {
        int count = 0;
        int cols = grid.getCols();
        int rows = grid.getRows();

        // previous row
        if (r > 0) {
            if (c > 0 && grid.isOn(r - 1, c - 1)) {
                count++;
            }
            if (grid.isOn(r - 1, c)) {
                count++;
            }
            if (c < cols - 1 && grid.isOn(r - 1, c + 1)) {
                count++;
            }
        }

        // current row
        if (c > 0 && grid.isOn(r, c - 1)) {
            count++;
        }
        if (c < cols - 1 && grid.isOn(r, c + 1)) {
            count++;
        }

        // next row
        if (r < rows - 1) {
            if (c > 0 && grid.isOn(r + 1, c - 1)) {
                count++;
            }
            if (grid.isOn(r + 1, c)) {
                count++;
            }
            if (c < cols - 1 && grid.isOn(r + 1, c + 1)) {
                count++;
            }
        }

        return count;
    }

    /**
     * Apply the rules of Conway's Game of Life.
     * 
     * @param cell the cell to update
     * @param count number of live neighbors
     */
    public static void updateCell(Cell cell, int count) {
        if (cell.isOn()) {
            if (count < 2) {
                // Any live cell with fewer than two live neighbors dies,
                // as if by underpopulation.
                cell.turnOff();
            } else if (count > 3) {
                // Any live cell with more than three live neighbors dies,
                // as if by overpopulation.
                cell.turnOff();
            } else {
                // Any live cell with two or three live neighbors lives on
                // to the next generation.
                cell.turnOn();
            }
        } else {
            if (count == 3) {
                // Any dead cell with exactly three live neighbors
                // becomes a live cell, as if by reproduction.
                cell.turnOn();
            }
        }
    }

    /**
     * Simulates one round of Conway's Game of Life.
     * 
     * @param grid the grid
     */
    public static void update(Grid grid) {
        int cols = grid.getCols();
        int rows = grid.getRows();

        // count neighbors before changing anything
        int[][] counts = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                counts[r][c] = countAlive(grid, r, c);
            }
        }

        // update each cell based on neighbor counts
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                updateCell(grid.getCell(r, c), counts[r][c]);
            }
        }
    }

    /**
     * Sets up the grid, creates the drawing, and plays the game.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        Grid grid = new Grid(30, 25, 20);
        grid.flip(1, 2);
        grid.flip(2, 2);
        grid.flip(3, 2);
        Drawing drawing = new Drawing(grid);

        // set up the window frame
        JFrame frame = new JFrame("Conway's Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(drawing);
        frame.pack();
        frame.setVisible(true);

        // main simulation loop
        Toolkit toolkit = frame.getToolkit();
        while (true) {

            // update the drawing
            update(grid);
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
