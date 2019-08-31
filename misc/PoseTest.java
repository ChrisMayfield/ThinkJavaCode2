import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests the Pose class.
 */
public class PoseTest {

    /**
     * Tests the equals method.
     */
    @Test
    public void testEquals() {
        Pose p1 = new Pose(1, 3, 0);
        Pose p2 = new Pose(1, 3, 45);
        Pose p3 = new Pose(5, 7, 45);
        Point p4 = new Point(5, 7);
        assertTrue(p1.equals(p2));
        assertFalse(p2.equals(p3));
        assertTrue(p3.equals(p4));
    }

    /**
     * Tests the toString method.
     */
    @Test
    public void testToString() {
        Pose p1 = new Pose(1, 3, 45);
        Pose p2 = new Pose(5, 7, 90);
        assertEquals("(1.0, 3.0) @45.0", p1.toString());
        assertEquals("(5.0, 7.0) @90.0", p2.toString());
    }

}
