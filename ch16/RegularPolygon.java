import java.awt.Color;

/**
 * A polygon that is equiangular (all angles are equal in measure) and
 * equilateral (all sides have the same length). It also has a color.
 */
public class RegularPolygon extends DrawablePolygon {

    public static final String[] NAMES = {null, null, null,
            "Triangle", "Square", "Pentagon", "Hexagon",
            "Heptagon", "Octagon", "Nonagon", "Decagon"};

    /**
     * Constructs a regular polygon, given the number of sides.
     * 
     * @param nsides the number of sides
     */
    public RegularPolygon(int nsides) {
        this(nsides, 50);
    }

    /**
     * Constructs a regular polygon, given the number of sides and the radius.
     * 
     * @param nsides the number of sides
     * @param radius from center to vertex
     */
    public RegularPolygon(int nsides, int radius) {
        this(nsides, radius, Color.BLACK);
    }

    /**
     * Constructs a regular polygon, given the number of sides, the radius, and
     * fill color.
     * 
     * @param nsides the number of sides
     * @param radius from center to vertex
     * @param color initial fill color
     */
    public RegularPolygon(int nsides, int radius, Color color) {

        // validate the arguments
        if (nsides < 3) {
            throw new IllegalArgumentException("invalid nsides");
        }
        if (radius <= 0) {
            throw new IllegalArgumentException("invalid radius");
        }
        if (color == null) {
            throw new NullPointerException("invalid color");
        }

        // initialize Polygon attributes
        this.npoints = nsides;
        this.xpoints = new int[nsides];
        this.ypoints = new int[nsides];
        this.color = color;

        // the amount to rotate for each vertex (in radians)
        double angle = 2.0 * Math.PI / nsides;

        // rotation that makes the polygon right-side up
        double rotate = Math.PI / nsides + Math.PI / 2.0;

        // compute x and y coordinates, centered at the origin
        for (int i = 0; i < nsides; i++) {
            double x = radius * Math.cos(i * angle + rotate);
            xpoints[i] = (int) Math.round(x);
            double y = radius * Math.sin(i * angle + rotate);
            ypoints[i] = (int) Math.round(y);
        }
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
