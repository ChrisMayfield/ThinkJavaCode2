import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Smoother version using a timer.
 */
public class Sim4 implements ActionListener {

    private Drawing drawing;
    private JFrame frame;

    /**
     * Set up the drawing and window frame.
     */
    public Sim4() {
        // create some regular polygons
        MovingPolygon mp = new MovingPolygon(8, 30);
        RotatingPolygon rp = new RotatingPolygon(5, 50);

        // move them out of the corner
        mp.translate(100, 100);
        rp.translate(200, 200);

        // create drawing, add polygons
        drawing = new Drawing(800, 600);
        drawing.add(mp);
        drawing.add(rp);

        // set up the window frame
        frame = new JFrame("Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(drawing);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Create and start the timer.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Sim4 sim = new Sim4();
        Timer timer = new Timer(1000 / 60, sim);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        drawing.nextact();
        drawing.repaint();
        frame.getToolkit().sync();
    }

}
