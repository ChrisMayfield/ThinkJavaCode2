import java.awt.Graphics;

/**
 * 2D array of cells that represent Conway's Game of Life.
 */
public class Grid {

    private final int rows;
    private final int cols;
    private final int size;

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

        // store the configuration
        this.rows = rows;
        this.cols = cols;
        this.size = size;

        // build 2D array of cells
        this.array = new Cell[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                this.array[r][c] = new Cell(c * size, r * size, size);
            }
        }
    }

    /**
     * Paints the grid on the screen.
     * 
     * @param g graphics context
     */
    public void draw(Graphics g) {
        for (Cell[] row : array) {
            for (Cell cell : row) {
                cell.draw(g);
            }
        }
    }

    /**
     * Toggles the cell color.
     * 
     * @param r row index
     * @param c column index
     */
    public void flip(int r, int c) {
        Cell cell = array[r][c];
        if (cell.isOff()) {
            cell.turnOn();
        } else {
            cell.turnOff();
        }
    }

    /**
     * @return total height of the grid
     */
    public int height() {
        return rows * size;
    }

    /**
     * @return total width of the grid
     */
    public int width() {
        return cols * size;
    }

    /**
     * Counts the number of live neighbors (without going out of bounds).
     * 
     * @param r row index
     * @param c column index
     * @return number of live neighbors
     */
    public int countAlive(int r, int c) {
        int count = 0;

        // previous row
        if (r > 0) {
            if (c > 0 && array[r - 1][c - 1].isOn()) {
                count++;
            }
            if (array[r - 1][c].isOn()) {
                count++;
            }
            if (c < cols - 1 && array[r - 1][c + 1].isOn()) {
                count++;
            }
        }

        // current row
        if (c > 0 && array[r][c - 1].isOn()) {
            count++;
        }
        if (c < cols - 1 && array[r][c + 1].isOn()) {
            count++;
        }

        // next row
        if (r < rows - 1) {
            if (c > 0 && array[r + 1][c - 1].isOn()) {
                count++;
            }
            if (array[r + 1][c].isOn()) {
                count++;
            }
            if (c < cols - 1 && array[r + 1][c + 1].isOn()) {
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
                updateCell(array[r][c], counts[r][c]);
            }
        }
    }

}
