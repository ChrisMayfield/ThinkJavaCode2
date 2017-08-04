import java.awt.Rectangle;

/**
 * Example from "My method doesn't return what I expect."
 */
public class Complex {

    public static Rectangle intersection(Rectangle a, Rectangle b) {
        int x1 = Math.min(a.x, b.x);
        int y1 = Math.min(a.y, b.y);
        int x2 = Math.max(a.x + a.width, b.x + b.width);
        int y2 = Math.max(a.y + a.height, b.y + b.height);
        Rectangle rect = new Rectangle(x1, y1, x2 - x1, y2 - y1);
        return rect;
    }

    public static void main(String[] args) {
        Rectangle x = new Rectangle(0, 0, 10, 10);
        Rectangle y = new Rectangle(-5, -5, -5, -5);
        System.out.println(intersection(x, y));
    }

}
