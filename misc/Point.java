/**
 * An immutable point in two-dimensional space.
 */
public class Point {

    public static final double DELTA = 0.001;

    private final double x;
    private final double y;

    /**
     * Constructs a point at the given location.
     * 
     * @param x the X coordinate
     * @param y the Y coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the X coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * @return the Y coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Computes the distance between two points.
     * 
     * @param pt the other point
     * @return Euclidean distance
     */
    public double distance(Point pt) {
        double dx = this.x - pt.x;
        double dy = this.y - pt.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Determines whether or not two points are equal.
     * 
     * @param obj the other point
     * @return true if this equals obj
     */
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point pt = (Point) obj;
            return distance(pt) < DELTA;
        }
        return super.equals(obj);
    }

    /**
     * @return string representation of the point
     */
    public String toString() {
        return String.format("(%.1f, %.1f)", this.x, this.y);
    }

}
