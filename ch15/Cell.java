import java.awt.Color;
import java.awt.Graphics;

/**
 * A square at a fixed location that changes color.
 */
public class Cell {

    public static final Color OFF = Color.WHITE;
    public static final Color ON = Color.BLACK;

    private final int x;
    private final int y;
    private final int size;
    private Color color;

    /**
     * Constructs a new cell, initially turned off.
     * 
     * @param x the X coordinate
     * @param y the Y coordinate
     * @param size number of pixels
     */
    public Cell(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = OFF;
    }

    /**
     * Draws the cell on the screen.
     * 
     * @param g graphics context
     */
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(x + 1, y + 1, size - 1, size - 1);
        g.setColor(Color.LIGHT_GRAY);
        g.drawRect(x, y, size, size);
    }

    /**
     * @return true if the color is OFF
     */
    public boolean isOff() {
        return color == OFF;
    }

    /**
     * @return true if the color is ON
     */
    public boolean isOn() {
        return color == ON;
    }

    /**
     * Sets the cell's color to OFF.
     */
    public void turnOff() {
        color = OFF;
    }

    /**
     * Sets the cell's color to ON.
     */
    public void turnOn() {
        color = ON;
    }

}
