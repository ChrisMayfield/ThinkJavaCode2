import java.awt.Color;
import java.awt.Graphics;

/**
 * A polygon that periodically changes colors on/off.
 */
public class BlinkingPolygon extends RegularPolygon {

    protected boolean visible;
    protected int count;

    /**
     * Constructs a blinking polygon.
     * 
     * @param nsides the number of sides
     * @param radius from center to vertex
     * @param color initial fill color
     */
    public BlinkingPolygon(int nsides, int radius, Color color) {
        super(nsides, radius, color);
        visible = true;
        count = 0;
    }

    @Override
    public void draw(Graphics g) {
        if (visible) {
            super.draw(g);
        }
    }

    @Override
    public void step() {
        // toggle visibility every 10 steps
        count++;
        if (count == 10) {
            visible = !visible;
            count = 0;
        }
    }

}
