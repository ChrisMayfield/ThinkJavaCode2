import java.awt.Color;

/**
 * A polygon that represents a small burrowing mammal.
 */
public class Mole extends RegularPolygon {

    public static final Color BROWN = new Color(153, 102, 0);

    /**
     * Creates a mole at the given location.
     * 
     * @param x the X coordinate
     * @param y the Y coordinate
     */
    public Mole(int x, int y) {
        super(10, 20, BROWN);
        translate(x, y);
    }

    /**
     * Updates the state of the mole when clicked.
     */
    public void whack() {
        setColor(Color.LIGHT_GRAY);
    }

}
