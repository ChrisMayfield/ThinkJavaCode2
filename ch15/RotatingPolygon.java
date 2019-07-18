import java.awt.Graphics;
import java.awt.Polygon;

/**
 * A polygon that rotates each time act is called.
 */
public abstract class RotatingPolygon extends Polygon implements Actor {

    private int xmid;
    private int ymid;

    /**
     * Sets the rotation point to the middle.
     */
    public void center() {
        for (int x : xpoints) {
            xmid += x;
        }
        xmid /= npoints;
        for (int y : ypoints) {
            ymid += y;
        }
        ymid /= npoints;
    }

    /**
     * Rotates the triangle around its center point.
     */
    public void act() {
        final double COS = Math.cos(Math.PI / 180);
        final double SIN = Math.sin(Math.PI / 180);
        for (int i = 0; i < npoints; i++) {
            double t = xpoints[i] - xmid;
            double v = ypoints[i] - ymid;
            xpoints[i] = (int) (xmid + t * COS - v * SIN);
            ypoints[i] = (int) (ymid + v * COS + t * SIN);
        }
    }

    /**
     * Paints the triangle on the screen.
     * 
     * @param g graphics context
     */
    public void draw(Graphics g) {
        g.fillPolygon(this);
    }

}
