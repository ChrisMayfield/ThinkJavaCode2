import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests the Point class.
 */
public class PointTest {

    /**
     * Tests the distance method.
     */
    @Test
    public void testDistance() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        assertEquals(0.0, p1.distance(p1), Point.DELTA);
        assertEquals(5.0, p1.distance(p2), Point.DELTA);
    }

    /**
     * Tests the equals method.
     */
    @Test
    public void testEquals() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        Point p3 = new Point(3, 4);
        Point p4 = new Point(3, 5);
        assertTrue(p1.equals(p2));
        assertFalse(p2.equals(p3));
        assertFalse(p3.equals(p4));
    }

    /**
     * Tests the toString method.
     */
    @Test
    public void testToString() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        assertEquals("(0.0, 0.0)", p1.toString());
        assertEquals("(3.0, 4.0)", p2.toString());
    }

}
