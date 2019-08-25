import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Arrays;

/**
 * A polygon that rotates each time act is called.
 */
public class RotatingPolygon extends Polygon implements Actor {

    private int xmid;
    private int ymid;

    private int angle; // in degrees

    private int[] x0; // original xpoints
    private int[] y0; // original ypoints

    /**
     * Sets the rotation point to the middle.
     */
    public void center() {

        // find the average x and y values
        int xsum = 0;
        int ysum = 0;
        for (int x : xpoints) {
            xsum += x;
        }
        for (int y : ypoints) {
            ysum += y;
        }
        this.xmid = (int) Math.round(xsum / npoints);
        this.ymid = (int) Math.round(ysum / npoints);

        // reset the rotation direction
        this.angle = 359;

        // save the original x and y points
        x0 = Arrays.copyOf(xpoints, npoints);
        y0 = Arrays.copyOf(ypoints, npoints);
    }

    /**
     * Rotates the polygon around its center.
     */
    public void act() {
        // update the rotation angle
        angle = (angle + 1) % 360;
        final double RAD = Math.toRadians(angle);
        final double COS = Math.cos(RAD);
        final double SIN = Math.sin(RAD);

        // translate the polygon points
        for (int i = 0; i < npoints; i++) {
            double t = x0[i] - xmid;
            double v = y0[i] - ymid;
            xpoints[i] = (int) Math.round(xmid + t * COS - v * SIN);
            ypoints[i] = (int) Math.round(ymid + t * SIN + v * COS);
        }
    }

    /**
     * Paints the polygon on the screen.
     * 
     * @param g graphics context
     */
    public void draw(Graphics g) {
        g.fillPolygon(this);
    }

}
