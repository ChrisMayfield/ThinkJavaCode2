import java.awt.Canvas;
import java.awt.Graphics;

/**
 * Drawing of a grid.
 */
public class Drawing extends Canvas {

    private Grid grid;

    /**
     * Constructs a drawing for the grid.
     * 
     * @param grid the initialized grid
     */
    public Drawing(Grid grid) {
        this.grid = grid;
        setSize(grid.width(), grid.height());
    }

    /**
     * Draws the grid, cell by cell.
     * 
     * @param g graphics context
     */
    @Override
    public void paint(Graphics g) {
        grid.draw(g);
    }

    /**
     * Overriding this method helps the simulation run more smoothly. Normally
     * the Canvas is cleared before painting, but there is no need to clear it
     * since paint draws the entire grid.
     * 
     * @param g graphics context
     */
    @Override
    public void update(Graphics g) {
        grid.draw(g);
    }

}
