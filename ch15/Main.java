import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 * Example simulation of Conway's Game of Life.
 */
public class Main {

    public static final int SIZE = 20;

    /**
     * Returns an example of a Blinker and a Glider.
     * 
     * @return hard-coded grid
     */
    public static Grid example() {
        Grid grid = new Grid(30, 25, SIZE);
        grid.flip(1, 2);
        grid.flip(2, 2);
        grid.flip(3, 2);
        grid.flip(6, 1);
        grid.flip(7, 2);
        grid.flip(7, 3);
        grid.flip(8, 1);
        grid.flip(8, 2);
        return grid;
    }

    /**
     * Creates a grid based on a plain text file.
     * http://www.conwaylife.com/wiki/Plaintext
     * 
     * @param path the path to the file
     * @return grid based on file contents
     */
    public static Grid readFile(String path) {

        // open the file at the given path
        Scanner scan = null;
        try {
            File file = new File(path);
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // read file contents into memory
        List<String> data = new ArrayList<String>();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            // ignore blank lines and comments
            if (!line.isEmpty() && !line.startsWith("!")) {
                data.add(line);
            }
        }

        // validate the file contents
        int rows = data.size();
        if (rows == 0) {
            throw new IllegalArgumentException("empty file");
        }
        int cols = data.get(0).length();
        for (String line : data) {
            if (line.length() != cols) {
                throw new IllegalArgumentException("invalid file");
            }
        }

        // create the resulting grid
        Grid grid = new Grid(rows, cols, SIZE);
        for (int r = 0; r < rows; r++) {
            String line = data.get(r);
            for (int c = 0; c < cols; c++) {
                char x = line.charAt(c);
                if (x == 'O') {
                    grid.flip(r, c);
                }
            }
        }
        return grid;
    }

    /**
     * Sets up the grid, creates the drawing, and plays the game.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // create the grid drawing
        Grid grid;
        if (args.length != 1) {
            grid = example();
        } else {
            grid = readFile(args[0]);
        }
        Drawing drawing = new Drawing(grid);

        // set up the window frame
        JFrame frame = new JFrame("Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(drawing);
        frame.pack();
        frame.setVisible(true);

        // main simulation loop
        Toolkit toolkit = frame.getToolkit();
        while (true) {

            // update the drawing
            grid.update();
            drawing.repaint();

            // delay the simulation
            try {
                Thread.sleep(500);
                toolkit.sync();
            } catch (InterruptedException e) {
                // do nothing
            }
        }
    }

}
