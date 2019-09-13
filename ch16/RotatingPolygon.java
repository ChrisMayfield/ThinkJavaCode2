import java.util.Arrays;

/**
 * A polygon that rotates around its center.
 */
public class RotatingPolygon extends RegularPolygon {

    private int xmid;
    private int ymid;

    private int angle; // in degrees

    private int[] x0; // original xpoints
    private int[] y0; // original ypoints

    /**
     * Constructs a rotating polygon.
     * 
     * @param nsides the number of sides
     * @param radius from center to vertex
     */
    public RotatingPolygon(int nsides, int radius) {
        super(nsides, radius);
        center();
    }

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
        xmid = (int) Math.round(xsum / npoints);
        ymid = (int) Math.round(ysum / npoints);

        // reset the rotation direction
        angle = 359;

        // save the original x and y points
        x0 = Arrays.copyOf(xpoints, npoints);
        y0 = Arrays.copyOf(ypoints, npoints);
    }

    @Override
    public void step() {
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

    @Override
    public void translate(int deltaX, int deltaY) {
        super.translate(deltaX, deltaY);
        center();
    }

}
