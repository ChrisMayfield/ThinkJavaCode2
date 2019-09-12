import java.awt.Graphics;

/**
 * Graphical simulation element.
 */
public interface Actor {

    /**
     * Draws the simulation element in the context.
     * 
     * @param g graphics context
     */
    void draw(Graphics g);

    /**
     * Updates the state of the simulation element.
     */
    void step();

}
