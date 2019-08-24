import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 * 2D array of cells.
 */
public class Grid extends Canvas {

    private final int rows;
    private final int cols;

    /** Cells stored in row-major order. */
    private Cell[][] array;

    /**
     * Constructs a drawing of given size.
     * 
     * @param rows number of rows
     * @param cols number of columns
     * @param size pixels per cell
     */
    public Grid(int rows, int cols, int size) {

        // build 2D array of cells
        this.rows = rows;
        this.cols = cols;
        this.array = new Cell[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                this.array[r][c] = new Cell(c * size, r * size, size);
            }
        }

        // initialize the display
        setSize(cols * size, rows * size);
    }

    /**
     * Toggles the cell color.
     * 
     * @param r row index
     * @param c column index
     */
    public void flip(int r, int c) {
        Cell cell = array[r][c];
        if (cell.alive()) {
            cell.setColor(Color.WHITE);
        } else {
            cell.setColor(Color.BLACK);
        }
    }

    /**
     * Counts the number of live neighbors (without going out of bounds).
     * 
     * @param r row index
     * @param c column index
     * @return number of live neighbors
     */
    public int countLive(int r, int c) {
        int count = 0;

        // previous row
        if (r > 0) {
            if (c > 0 && array[r - 1][c - 1].alive()) {
                count++;
            }
            if (array[r - 1][c].alive()) {
                count++;
            }
            if (c < cols - 1 && array[r - 1][c + 1].alive()) {
                count++;
            }
        }

        // current row
        if (c > 0 && array[r][c - 1].alive()) {
            count++;
        }
        if (c < cols - 1 && array[r][c + 1].alive()) {
            count++;
        }

        // next row
        if (r < rows - 1) {
            if (c > 0 && array[r + 1][c - 1].alive()) {
                count++;
            }
            if (array[r + 1][c].alive()) {
                count++;
            }
            if (c < cols - 1 && array[r + 1][c + 1].alive()) {
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
    public void updateCell(Cell cell, int count) {
        if (cell.alive()) {
            if (count < 2) {
                // Any live cell with fewer than two live neighbors dies,
                // as if by underpopulation.
                cell.setColor(Color.WHITE);
            } else if (count > 3) {
                // Any live cell with more than three live neighbors dies,
                // as if by overpopulation.
                cell.setColor(Color.WHITE);
            } else {
                // Any live cell with two or three live neighbors lives on
                // to the next generation.
                cell.setColor(Color.BLACK);
            }
        } else {
            if (count == 3) {
                // Any dead cell with exactly three live neighbors
                // becomes a live cell, as if by reproduction.
                cell.setColor(Color.BLACK);
            }
        }
    }

    /**
     * Simulates one round of Conway's Game of Life.
     */
    public void playGame() {

        // count neighbors
        int[][] counts = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                counts[r][c] = countLive(r, c);
            }
        }

        // update cells
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Cell cell = array[r][c];
                updateCell(cell, counts[r][c]);
            }
        }
    }

    /**
     * Draws the grid, cell by cell.
     * 
     * @param g graphics context
     */
    public void paint(Graphics g) {
        for (Cell[] row : array) {
            for (Cell cell : row) {
                cell.draw(g);
            }
        }
    }

    /**
     * Overriding this method makes the simulation more smooth, because the
     * Canvas does not need to be cleared before redrawing.
     * 
     * @param g graphics context
     */
    public void update(Graphics g) {
        paint(g);
    }

}
