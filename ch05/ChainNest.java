public class ChainNest {

    public static void main(String[] args) {
        int x = 0;

        if (x > 0) {
            System.out.println("x is positive");
        } else if (x < 0) {
            System.out.println("x is negative");
        } else {
            System.out.println("x is zero");
        }

        if (x > 0) {
            System.out.println("x is positive");
        } else {
            if (x < 0) {
                System.out.println("x is negative");
            } else {
                System.out.println("x is zero");
            }
        }
    }

}
