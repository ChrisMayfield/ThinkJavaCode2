/**
 * Infinite loop example.
 */
public class Infinite {

    public static void main(String[] args) {
        int x = 1;
        int y = -1;

        while (x > 0 && y < 0) {
            // do something to x
            // do something to y

            System.out.println("x: " + x);
            System.out.println("y: " + y);
            System.out.println("condition: " + (x > 0 && y < 0));
        }
    }

}
