/**
 * Langton's Ant.
 */
public class Langton extends Automaton {

    private int xpos;
    private int ypos;
    private int head; // 0=North, 1=East, 2=South, 3=West

    /**
     * Creates a grid with the ant in the center.
     * 
     * @param rows number of rows
     * @param cols number of columns
     */
    public Langton(int rows, int cols) {
        grid = new GridCanvas(rows, cols, 10);
        xpos = rows / 2;
        ypos = cols / 2;
        head = 0;
    }

    /**
     * Simulates one round of Langton's Ant.
     */
    public void update() {

        Cell cell = grid.cellAt(xpos, ypos);
        if (cell.isOn()) {
            // at a black square; flip color and turn left
            cell.turnOff();
            head = (head + 3) % 4;
        } else {
            // at a white square; flip color and turn right
            cell.turnOn();
            head = (head + 1) % 4;
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

        // TODO: draw a triangle to show the ant
    }

    /**
     * Creates and runs the simulation.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        String title = "Langton's Ant";
        Langton game = new Langton(61, 61);
        game.run(title, 750);
    }

}
