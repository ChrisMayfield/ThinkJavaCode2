import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * Specialization of Polygon that has a color and the ability to draw itself.
 */
public class ColorPolygon extends Polygon {

    public Color color;

    /**
     * Creates an empty polygon.
     */
    public ColorPolygon() {
        super();
        color = Color.GRAY;
    }

    /**
     * Draws the polygon on the screen.
     * 
     * @param g graphics context
     */
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillPolygon(this);
    }

}
