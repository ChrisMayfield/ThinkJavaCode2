import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Draws a collection of moles and listens for mouse events.
 */
public class MoleHill extends Drawing implements MouseListener {

    /**
     * Constructs an interactive drawing of given size.
     * 
     * @param width the width in pixels
     * @param height the height in pixels
     */
    public MoleHill(int width, int height) {
        super(width, height);
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        for (Object obj : getActors()) {
            if (obj instanceof Mole) {
                Mole mole = (Mole) obj;
                if (mole.contains(x, y)) {
                    mole.whack();
                }
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // ignore
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // ignore
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // ignore
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // ignore
    }

}
