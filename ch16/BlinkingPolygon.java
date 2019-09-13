import java.awt.Color;

/**
 * A polygon that periodically changes colors on/off.
 */
public class BlinkingPolygon extends RegularPolygon {

    private Color onColor;
    private int count;

    /**
     * Constructs a blinking polygon.
     * 
     * @param nsides the number of sides
     * @param radius from center to vertex
     * @param color initial fill color
     */
    public BlinkingPolygon(int nsides, int radius, Color color) {
        super(nsides, radius, color);
        onColor = color;
        count = 0;
    }

    @Override
    public void step() {
        // count to ten first
        count++;
        if (count >= 10) {
            count = 0;
            // toggle the color
            if (color != onColor) {
                color = onColor;
            } else {
                color = Color.WHITE;
            }
        }
    }

}
