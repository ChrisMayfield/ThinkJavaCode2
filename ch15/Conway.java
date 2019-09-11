import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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
        grid.flip(1, 2);
        grid.flip(2, 2);
        grid.flip(3, 2);
        grid.flip(6, 1);
        grid.flip(7, 2);
        grid.flip(7, 3);
        grid.flip(8, 1);
        grid.flip(8, 2);
    }

    /**
     * Creates a grid based on a plain text file.
     * http://www.conwaylife.com/wiki/Plaintext
     * 
     * @param path the path to the file
     */
    public Conway(String path) {

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
        List<String> data = new ArrayList<String>();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            // ignore blank lines and comments
            if (!line.isEmpty() && !line.startsWith("!")) {
                data.add(line);
            }
        }

        // validate the file contents
        int rows = data.size();
        if (rows == 0) {
            throw new IllegalArgumentException("empty file");
        }
        int cols = data.get(0).length();
        for (String line : data) {
            if (line.length() != cols) {
                throw new IllegalArgumentException("invalid file");
            }
        }

        // create the resulting grid
        grid = new GridCanvas(rows, cols, SIZE);
        for (int r = 0; r < rows; r++) {
            String line = data.get(r);
            for (int c = 0; c < cols; c++) {
                char x = line.charAt(c);
                if (x == 'O') {
                    grid.flip(r, c);
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
     */
    public void update() {
        int rows = grid.getRows();
        int cols = grid.getCols();

        // count neighbors before changing anything
        int[][] counts = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                counts[r][c] = countAlive(r, c);
            }
        }

        // update each cell based on neighbor counts
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                updateCell(grid.getCell(r, c), counts[r][c]);
            }
        }

        // update the display
        grid.repaint();
    }

}
