import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests the Triangle class.
 */
public class TriangleTest {

    /**
     * Tests an invalid triangle.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCollinear() {
        // straight line along the X-axis
        new Triangle(0, 0, 1, 0, 2, 0);
    }

    /**
     * Tests the toString method.
     */
    @Test
    public void testToString() {
        // 3-4-5 right triangle at origin
        Triangle t = new Triangle(0, 0, 0, 3, 4, 0);
        assertEquals("Triangle[(0, 0), (0, 3), (4, 0)]", t.toString());
    }

}
