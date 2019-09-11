/**
 * A cellular automaton consists of a grid of cells and has the ability to
 * update itself over time.
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
