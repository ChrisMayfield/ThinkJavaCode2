import java.awt.Graphics;

/**
 * 2D array of cells representing a game board.
 */
public class Grid {

    private final int rows;
    private final int cols;
    private final int size;

    /** Cells stored in row-major order. */
    private Cell[][] array;

    /**
     * Constructs a grid of given size.
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
     * Toggles the cell on/off.
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
     * @param r row index
     * @param c column index
     * @return true if the cell is on
     */
    public boolean isOn(int r, int c) {
        return array[r][c].isOn();
    }

    /**
     * @param r row index
     * @param c column index
     * @return the cell
     */
    public Cell getCell(int r, int c) {
        return array[r][c];
    }

    /**
     * @return number of rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * @return number of columns
     */
    public int getCols() {
        return cols;
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

}
