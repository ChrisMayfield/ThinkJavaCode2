import java.awt.Polygon;

/**
 * A three-sided polygon.
 */
public class Triangle extends Polygon {

    /**
     * Constructs a triangle at the given points.
     * 
     * @param ax 1st x-coordinate
     * @param ay 1st y-coordinate
     * @param bx 2nd x-coordinate
     * @param by 2nd y-coordinate
     * @param cx 3rd x-coordinate
     * @param cy 3rd y-coordinate
     */
    public Triangle(int ax, int ay, int bx, int by, int cx, int cy) {

        // check for invalid triangle
        int lhs = (cy - by) * (bx - ax);
        int rhs = (by - ay) * (cx - bx);
        if (lhs == rhs) {
            throw new IllegalArgumentException("points are collinear");
        }

        // store points of polygon
        xpoints = new int[] {ax, bx, cx};
        ypoints = new int[] {ay, by, cy};
        npoints = 3;
    }

    /**
     * @return string representation of the triangle
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Triangle[");
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
