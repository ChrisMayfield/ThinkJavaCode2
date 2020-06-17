import java.awt.Rectangle;

/**
 * Examples from Logic Errors section.
 */
public class Complex {

    /**
     * My method doesn't return what I expect.
     */
    public static Rectangle intersection(Rectangle a, Rectangle b) {
        int x1 = Math.min(a.x, b.x);
        int y1 = Math.min(a.y, b.y);
        int x2 = Math.max(a.x + a.width, b.x + b.width);
        int y2 = Math.max(a.y + a.height, b.y + b.height);
        Rectangle rect = new Rectangle(x1, y1, x2 - x1, y2 - y1);
        return rect;
    }

    /**
     * I've got a big, hairy expression and it doesn’t do what I expect.
     */
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(0, 0, 10, 10);
        Rectangle ngle = new Rectangle(-5, -5, -5, -5);
        System.out.println(intersection(rect, ngle));

        double halfWidth = 0.5 * rect.getWidth();
        double halfHeight = 0.5 * rect.getHeight();
        int dx = (int) Math.round(halfWidth);
        int dy = (int) Math.round(halfHeight);
        rect.translate(dx, dy);
    }

}
