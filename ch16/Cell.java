import java.awt.Color;
import java.awt.Graphics;

/**
 * A square at a fixed location that changes color.
 */
public class Cell {

    private final int x;
    private final int y;
    private final int size;
    private Color color;

    /**
     * Constructs a new cell.
     * 
     * @param x the X coordinate
     * @param y the Y coordinate
     * @param size number of pixels
     */
    public Cell(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = Color.WHITE;
    }

    /**
     * @return true if the cell is alive
     */
    public boolean alive() {
        return this.color == Color.BLACK;
    }

    /**
     * @return the cell's color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * @param color the new color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Paints the cell on the screen.
     * 
     * @param g graphics context
     */
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(this.x + 1, this.y + 1, this.size - 1, this.size - 1);
        g.setColor(Color.LIGHT_GRAY);
        g.drawRect(this.x, this.y, this.size, this.size);
    }

}
