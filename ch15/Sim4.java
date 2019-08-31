import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * Example simulation of stationary objects.
 */
public class Sim4 implements ActionListener {

    private Drawing drawing;
    private JFrame frame;

    public Sim4() {
        MovingPolygon mp = new MovingPolygon(8, 30);
        mp.translate(100, 100);
        drawing = new Drawing(800, 600);
        drawing.add(mp);

        frame = new JFrame("Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(drawing);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Test program that draws a few polygons.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Sim4 sim = new Sim4();
        new javax.swing.Timer(1000 / 50, sim).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        drawing.nextact();
        drawing.repaint();
        frame.getToolkit().sync();
    }

}
