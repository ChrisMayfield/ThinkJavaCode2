import java.awt.Graphics;
import java.awt.Polygon;

/**
 * A polygon that is equiangular (all angles are equal in measure) and
 * equilateral (all sides have the same length).
 */
public class RegularPolygon extends Polygon implements Actor {

    public static final String[] NAMES = {null, null, null,
            "Triangle", "Square", "Pentagon", "Hexagon",
            "Heptagon", "Octagon", "Nonagon", "Decagon"};

    /**
     * Constructs a regular polygon.
     * 
     * @param nsides the number of sides
     * @param length length of each side
     */
    public RegularPolygon(int nsides, int length) {

        // validate and store arguments
        if (nsides < 3 || nsides >= NAMES.length) {
            throw new IllegalArgumentException("invalid nsides");
        }
        if (length < 1) {
            throw new IllegalArgumentException("invalid length");
        }

        // initialize Polygon attributes
        npoints = nsides;
        xpoints = new int[nsides];
        ypoints = new int[nsides];

        // compute the radius, angle between vertexes, and rotation
        double radius = length / (2.0 * Math.sin(Math.PI / nsides));
        double angle = 2.0 * Math.PI / nsides;
        double rotate = Math.PI / nsides + Math.PI / 2.0;

        // compute x and y coordinates, centered around the origin
        for (int i = 0; i < nsides; i++) {
            xpoints[i] = (int) Math.round(
                    radius * Math.cos(i * angle + rotate));
            ypoints[i] = (int) Math.round(
                    radius * Math.sin(i * angle + rotate));
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(NAMES[npoints]);
        str.append('[');
        for (int i = 0; i < npoints; i++) {
            if (i > 0) {
                str.append(", ");
            }
            // append the next (x, y) point
            str.append('(');
            str.append(xpoints[i]);
            str.append(", ");
            str.append(ypoints[i]);
            str.append(')');
        }
        str.append(']');
        return str.toString();
    }

    @Override
    public void act() {
        // nothing to do
    }

    @Override
    public void draw(Graphics g) {
        System.out.println(this);
        g.drawPolygon(this);
    }

}
