/**
 * A point with an associated heading (in degrees).
 */
public class Pose extends Point {

    private final int heading;

    /**
     * Constructs a pose at the given location.
     * 
     * @param x the X coordinate
     * @param y the Y coordinate
     * @param heading the heading
     */
    public Pose(int x, int y, int heading) {
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
        return String.format("%s @%d", super.toString(), this.heading);
    }

}
