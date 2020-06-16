import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Draws a collection of actors.
 */
public class Drawing extends Canvas {

    private ArrayList<Actor> list;

    /**
     * Constructs a drawing of given size.
     * 
     * @param width the width in pixels
     * @param height the height in pixels
     */
    public Drawing(int width, int height) {
        setSize(width, height);
        setBackground(Color.WHITE);
        list = new ArrayList<Actor>();
    }

    /**
     * Adds a new actor to the drawing.
     * 
     * @param actor the object to add
     */
    public void add(Actor actor) {
        list.add(actor);
    }

    /**
     * Gets current actors as an array.
     * 
     * @return array of actor objects
     */
    public Object[] getActors() {
        return list.toArray();
    }

    /**
     * Draws all the actors on the canvas.
     * 
     * @param g graphics context
     */
    @Override
    public void paint(Graphics g) {
        for (Actor actor : list) {
            actor.draw(g);
        }
    }

    /**
     * Calls the step method of each actor and updates the drawing.
     */
    public void step() {
        for (Actor actor : list) {
            actor.step();
        }
        repaint();
    }

}
