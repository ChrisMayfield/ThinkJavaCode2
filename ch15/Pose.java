/**
 * A point with an associated heading (in degrees).
 */
public class Pose extends Point {

    private final double heading;

    /**
     * Constructs a pose at the given location.
     * 
     * @param x the X coordinate
     * @param y the Y coordinate
     * @param heading the heading
     */
    public Pose(double x, double y, double heading) {
        super(x, y);
        this.heading = heading;
    }

    /**
     * @return heading the heading
     */
    public double getHeading() {
        return heading;
    }

    /**
     * @return string representation of the pose
     */
    public String toString() {
        return String.format("%s @%.1f", super.toString(), this.heading);
    }

}
