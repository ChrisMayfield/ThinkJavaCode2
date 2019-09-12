import java.awt.Color;

/**
 * A polygon that changes colors on/off.
 */
public class BlinkingPolygon extends RegularPolygon {

    private Color onColor;

    /**
     * Constructs a blinking polygon.
     * 
     * @param nsides the number of sides
     * @param length length of each side
     * @param color initial fill color
     */
    public BlinkingPolygon(int nsides, int length, Color color) {
        super(nsides, length, color);
        onColor = color;
    }

    @Override
    public void step() {
        if (color != onColor) {
            color = onColor;
        } else {
            color = Color.WHITE;
        }
    }

}
