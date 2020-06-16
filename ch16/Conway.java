import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Conway's Game of Life.
 */
public class Conway extends Automaton {

    /**
     * Creates a grid with a Blinker and a Glider.
     */
    public Conway() {
        grid = new GridCanvas(30, 25, SIZE);
        grid.turnOn(1, 2);
        grid.turnOn(2, 2);
        grid.turnOn(3, 2);
        grid.turnOn(6, 1);
        grid.turnOn(7, 2);
        grid.turnOn(7, 3);
        grid.turnOn(8, 1);
        grid.turnOn(8, 2);
    }

    /**
     * Creates a grid based on a plain text file.
     * http://www.conwaylife.com/wiki/Plaintext
     * 
     * @param path the path to the file
     * @param margin how many cells to add
     */
    public Conway(String path, int margin) {

        // open the file at the given path
        Scanner scan = null;
        try {
            File file = new File(path);
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // read file contents into memory
        ArrayList<String> data = new ArrayList<String>();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            // only add non-comment lines
            if (!line.startsWith("!")) {
                data.add(line);
            }
        }

        // determine number of rows and columns in the pattern
        int rows = data.size();
        int cols = 0;
        for (String line : data) {
            if (cols < line.length()) {
                cols = line.length();
            }
        }
        if (rows == 0 || cols == 0) {
            throw new IllegalArgumentException("no cells found");
        }

        // create the resulting grid with margin of extra cells
        grid = new GridCanvas(rows + 2 * margin, cols + 2 * margin, SIZE);
        for (int r = 0; r < rows; r++) {
            String line = data.get(r);
            for (int c = 0; c < line.length(); c++) {
                char x = line.charAt(c);
                if (x == 'O') {
                    grid.turnOn(r + margin, c + margin);
                }
            }
        }
    }

    /**
     * Counts the number of live neighbors around a cell.
     * 
     * @param r row index
     * @param c column index
     * @return number of live neighbors
     */
    private int countAlive(int r, int c) {
        int count = 0;
        count += grid.test(r - 1, c - 1);
        count += grid.test(r - 1, c);
        count += grid.test(r - 1, c + 1);
        count += grid.test(r, c - 1);
        count += grid.test(r, c + 1);
        count += grid.test(r + 1, c - 1);
        count += grid.test(r + 1, c);
        count += grid.test(r + 1, c + 1);
        return count;
    }

    /**
     * Apply the update rules of Conway's Game of Life.
     * 
     * @param cell the cell to update
     * @param count number of live neighbors
     */
    private static void updateCell(Cell cell, int count) {
        if (cell.isOn()) {
            if (count < 2 || count > 3) {
                // Any live cell with fewer than two live neighbors dies,
                // as if by underpopulation.
                // Any live cell with more than three live neighbors dies,
                // as if by overpopulation.
                cell.turnOff();
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
     * Counts the neighbors before changing anything.
     * 
     * @return number of neighbors for each cell
     */
    private int[][] countNeighbors() {
        int rows = grid.numRows();
        int cols = grid.numCols();

        int[][] counts = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                counts[r][c] = countAlive(r, c);
            }
        }
        return counts;
    }

    /**
     * Updates each cell based on neighbor counts.
     * 
     * @param counts number of neighbors for each cell
     */
    private void updateGrid(int[][] counts) {
        int rows = grid.numRows();
        int cols = grid.numCols();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Cell cell = grid.getCell(r, c);
                updateCell(cell, counts[r][c]);
            }
        }
    }

    /**
     * Simulates one round of Conway's Game of Life.
     */
    public void update() {
        int[][] counts = countNeighbors();
        updateGrid(counts);
    }

    /**
     * Creates and runs the simulation.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        String title = "Conway's Game of Life";
        Conway game = new Conway("pulsar.cells", 2);
        game.run(title, 2);
    }

}
