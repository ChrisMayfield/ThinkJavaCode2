import java.awt.Canvas;
import java.awt.Graphics;

/**
 * 2D array of cells representing a rectangular grid.
 * 
 * @author Chris Mayfield
 * @version 7.1.0
 */
public class GridCanvas extends Canvas {

    /** Cells stored in row-major order. */
    private Cell[][] array;

    /**
     * Constructs a grid of given size.
     * 
     * @param rows number of rows
     * @param cols number of columns
     * @param size pixels per cell
     */
    public GridCanvas(int rows, int cols, int size) {

        // build 2D array of cells
        array = new Cell[rows][cols];
        for (int r = 0; r < rows; r++) {
            int y = r * size;
            for (int c = 0; c < cols; c++) {
                int x = c * size;
                array[r][c] = new Cell(x, y, size);
            }
        }

        // set the canvas size
        setSize(cols * size, rows * size);
    }

    /**
     * Gets the number of rows.
     * 
     * @return number of rows
     */
    public int numRows() {
        return array.length;
    }

    /**
     * Gets the number of columns.
     * 
     * @return number of columns
     */
    public int numCols() {
        return array[0].length;
    }

    /**
     * Gets the cell at index (r, c).
     * 
     * @param r row index
     * @param c column index
     * @return the cell
     */
    public Cell getCell(int r, int c) {
        return array[r][c];
    }

    /**
     * Convenience method that turns on the cell at (r, c).
     * 
     * @param r row index
     * @param c column index
     */
    public void turnOn(int r, int c) {
        array[r][c].turnOn();
    }

    /**
     * Returns 1 if the cell at (r, c) exists and is on. Returns 0 if the cell
     * doesn't exist or is off.
     * 
     * @param r row index
     * @param c column index
     * @return 1 or 0
     */
    public int test(int r, int c) {
        try {
            if (array[r][c].isOn()) {
                return 1;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // cell doesn't exist
        }
        return 0;
    }

    /**
     * Draws the grid, cell by cell.
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
     * Paints the grid on the screen.
     * 
     * @param g graphics context
     */
    public void paint(Graphics g) {
        draw(g);
    }

    /**
     * Overriding this method helps the simulation run more smoothly. Normally
     * the Canvas is cleared before painting, but there is no need to clear it
     * since the paint method draws the entire grid.
     * 
     * @param g graphics context
     */
    public void update(Graphics g) {
        draw(g);
    }

}
