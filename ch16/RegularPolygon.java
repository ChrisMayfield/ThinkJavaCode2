import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * A polygon that is equiangular (all angles are equal in measure) and
 * equilateral (all sides have the same length). It also has a color.
 */
public class RegularPolygon extends Polygon implements Actor {

    public static final String[] NAMES = {null, null, null,
            "Triangle", "Square", "Pentagon", "Hexagon",
            "Heptagon", "Octagon", "Nonagon", "Decagon"};

    protected Color color;

    /**
     * Constructs a regular polygon, given the number of sides.
     * 
     * @param nsides the number of sides
     */
    public RegularPolygon(int nsides) {
        this(nsides, 100);
    }

    /**
     * Constructs a regular polygon, given the number of sides and length of
     * each side.
     * 
     * @param nsides the number of sides
     * @param length length of each side
     */
    public RegularPolygon(int nsides, int length) {
        this(nsides, length, Color.BLACK);
    }

    /**
     * Constructs a regular polygon, given the number of sides, the length of
     * each side, and fill color.
     * 
     * @param nsides the number of sides
     * @param length length of each side
     * @param color initial fill color
     */
    public RegularPolygon(int nsides, int length, Color color) {

        // validate and store arguments
        if (nsides < 3) {
            throw new IllegalArgumentException("invalid nsides");
        }
        if (length < 1) {
            throw new IllegalArgumentException("invalid length");
        }
        if (color == null) {
            throw new NullPointerException("invalid color");
        }

        // initialize Polygon attributes
        this.npoints = nsides;
        this.xpoints = new int[nsides];
        this.ypoints = new int[nsides];
        this.color = color;

        // radius of the polygon (distance from center to vertex)
        double radius = 0.5 * length / Math.sin(Math.PI / nsides);

        // the angle (in radians) at each vertex
        double angle = 2.0 * Math.PI / nsides;

        // rotation that makes the polygon right-side up
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
    public void step() {
        // nothing to do
    }

    @Override
    public void draw(Graphics g) {
        // System.out.println(this);
        g.setColor(color);
        g.fillPolygon(this);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (npoints < NAMES.length) {
            str.append(NAMES[npoints]);
        } else {
            str.append("Polygon");
        }
        // append the list of vertexes
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

}
