import java.awt.Color;
import java.awt.Graphics;

/**
 * A square at a fixed location that changes color.
 * 
 * @author Chris Mayfield
 * @version 7.1.0
 */
public class Cell {

    public static final Color[] COLORS = {Color.WHITE, Color.BLACK};

    private final int x;
    private final int y;
    private final int size;
    private int state;

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
        this.state = 0;
    }

    /**
     * Draws the cell on the screen.
     * 
     * @param g graphics context
     */
    public void draw(Graphics g) {
        g.setColor(COLORS[state]);
        g.fillRect(x + 1, y + 1, size - 1, size - 1);
        g.setColor(Color.LIGHT_GRAY);
        g.drawRect(x, y, size, size);
    }

    /**
     * Tests whether the cell is off.
     * 
     * @return true if the cell is off
     */
    public boolean isOff() {
        return state == 0;
    }

    /**
     * Tests whether the cell is on.
     * 
     * @return true if the cell is on
     */
    public boolean isOn() {
        return state == 1;
    }

    /**
     * Sets the cell's state to off.
     */
    public void turnOff() {
        state = 0;
    }

    /**
     * Sets the cell's state to on.
     */
    public void turnOn() {
        state = 1;
    }

}
