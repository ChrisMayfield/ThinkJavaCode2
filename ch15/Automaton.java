/**
 * A cellular automaton consists of a grid of cells and follows a set of rules
 * that update the grid over time.
 */
public abstract class Automaton {

    public static final int SIZE = 20;

    protected GridCanvas grid;

    /**
     * @return the grid
     */
    public GridCanvas getGrid() {
        return grid;
    }

    /**
     * Updates the automaton.
     */
    public abstract void update();

}
