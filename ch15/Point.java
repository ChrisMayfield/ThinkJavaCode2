/**
 * An immutable point in two-dimensional space.
 */
public class Point {

    private final int x;
    private final int y;

    /**
     * Constructs a point at the given location.
     * 
     * @param x the X coordinate
     * @param y the Y coordinate
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the X coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * @return the Y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Computes the distance between two points.
     * 
     * @param pt the other point
     * @return Euclidean distance
     */
    public double distance(Point pt) {
        int dx = this.x - pt.x;
        int dy = this.y - pt.y;
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
            return this.x == pt.x && this.y == pt.y;
        }
        return super.equals(obj);
    }

    /**
     * @return string representation of the point
     */
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

}
