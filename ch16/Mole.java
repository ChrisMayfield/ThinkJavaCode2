import java.awt.Color;

/**
 * A polygon that represents a small burrowing mammal.
 */
public class Mole extends BlinkingPolygon {

    public static final Color BROWN = new Color(153, 102, 0);

    private boolean alive;

    /**
     * Creates a mole at the given location.
     * 
     * @param x the X coordinate
     * @param y the Y coordinate
     */
    public Mole(int x, int y) {
        super(10, 20, BROWN);
        translate(x, y);
        alive = true;
    }

    @Override
    public void act() {
        // blink on/off at random times
        if (alive && Math.random() < 0.5) {
            super.act();
        }
    }

    /**
     * Updates the state of the mole when clicked.
     */
    public void whack() {
        // ignore whack when invisible
        if (color == BROWN) {
            color = Color.LIGHT_GRAY;
            alive = false;
        }
    }

}
