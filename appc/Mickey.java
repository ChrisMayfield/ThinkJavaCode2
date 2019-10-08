import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JFrame;

public class Mickey extends Canvas {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mickey Mouse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Mickey();
        canvas.setSize(400, 400);
        canvas.setBackground(Color.white);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        Rectangle bb = new Rectangle(100, 100, 200, 200);
        mickey(g, bb);
    }

    public void boxOval(Graphics g, Rectangle bb) {
        g.fillOval(bb.x, bb.y, bb.width, bb.height);
    }

    public void mickey(Graphics g, Rectangle bb) {
        boxOval(g, bb);

        int hx = bb.width / 2;
        int hy = bb.height / 2;
        Rectangle half = new Rectangle(bb.x, bb.y, hx, hy);

        half.translate(-hx / 2, -hy / 2);
        boxOval(g, half);

        half.translate(hx * 2, 0);
        boxOval(g, half);
    }

}
