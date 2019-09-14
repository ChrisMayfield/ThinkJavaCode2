import java.awt.Color;
import java.awt.Graphics;

/**
 * A polygon that periodically changes colors on/off.
 */
public class BlinkingPolygon extends RegularPolygon {

    private boolean drawFlag;
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
        drawFlag = true;
        count = 0;
    }
    
    @Override
    public void step() {
        // every 10 steps toggle drawFlag
        count++;
        if (count == 10) {
            count = 0;
            drawFlag = !drawFlag;
        }
    }
    
    @Override
    public void draw(Graphics g) {
    	if (drawFlag) {
    		super.draw(g);
    	}
    }
}
