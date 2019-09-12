import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Smoother version of Sim2 using a timer.
 */
public class Sim3 implements ActionListener {

    private Drawing drawing;
    private Toolkit toolkit;

    /**
     * Set up the drawing and window frame.
     */
    public Sim3() {
        // create some regular polygons
        BlinkingPolygon bp = new BlinkingPolygon(3, 10, Color.BLUE);
        MovingPolygon mp = new MovingPolygon(8, 30);
        RotatingPolygon rp = new RotatingPolygon(5, 50);

        // move them out of the corner
        bp.translate(50, 50);
        mp.translate(100, 100);
        rp.translate(200, 200);

        // create drawing, add polygons
        drawing = new Drawing(800, 600);
        drawing.add(bp);
        drawing.add(mp);
        drawing.add(rp);

        // set up the window frame
        JFrame frame = new JFrame("Drawing with ActionListener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(drawing);
        frame.pack();
        frame.setVisible(true);
        toolkit = frame.getToolkit();
    }

    /**
     * Create and start the timer.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Sim3 sim = new Sim3();
        Timer timer = new Timer(50, sim);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        toolkit.sync();
        drawing.next();
    }

}
