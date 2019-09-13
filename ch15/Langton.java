/**
 * Langton's Ant.
 */
public class Langton extends Automaton {

    private int xpos;
    private int ypos;
    private int head; // 0=North, 1=East, 2=South, 3=West

    /**
     * Creates a grid with the ant in the center.
     */
    public Langton(int nrows, int ncols) {
        grid = new GridCanvas(nrows, ncols, 10);
        xpos = nrows / 2;
        ypos = ncols / 2;
        head = 0;
    }

    /**
     * Simulates one round of Langton's Ant.
     */
    public void update() {

        Cell cell = grid.getCell(xpos, ypos);
        if (cell.isOn()) {
            // at a black square; flip color and turn left
            cell.turnOff();
            head -= 1;
            if (head < 0) {
                head = 3;
            }
        } else {
            // at a white square; flip color and turn right
            cell.turnOn();
            head += 1;
            if (head > 3) {
                head = 0;
            }
        }

        // move forward one unit
        switch (head) {
            case 0:
                ypos -= 1;
                break;
            case 1:
                xpos += 1;
                break;
            case 2:
                ypos += 1;
                break;
            case 3:
                xpos -= 1;
                break;
        }

        // update the display
        grid.repaint();
    }

}
