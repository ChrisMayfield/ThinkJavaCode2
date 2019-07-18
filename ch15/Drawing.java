import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Draws a collection of actors.
 */
public class Drawing extends Canvas {

    private ArrayList<Actor> actors;

    /**
     * Constructs a drawing of given size.
     * 
     * @param width the width in pixels
     * @param height the height in pixels
     */
    public Drawing(int width, int height) {
        setSize(width, height);
        setBackground(Color.white);
        actors = new ArrayList<Actor>();
    }

    /**
     * Adds a new actor to the drawing.
     * 
     * @param actor the actor to add
     */
    public void add(Actor actor) {
        actors.add(actor);
    }

    /**
     * Calls the act method of each actor.
     */
    public void action() {
        for (Actor actor : actors) {
            actor.act();
        }
    }

    /**
     * Draws all the actors on the canvas.
     * 
     * @param g graphics context
     */
    public void paint(Graphics g) {
        for (Actor actor : actors) {
            actor.draw(g);
        }
    }

}
