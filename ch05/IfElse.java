public class IfElse {

    public static void main(String[] args) {
        int x = 17;
        int n = 18;

        if (x > 0) {
            System.out.println("x is positive");
        }

        if (x % 2 == 0) {
            System.out.println("x is even");
        } else {
            System.out.println("x is odd");
        }

        // look, no braces...bad idea!
        if (x % 2 == 0)
            System.out.println("x is even");
        else
            System.out.println("x is odd");

        if (x > 0)
            System.out.println("x is positive");
            System.out.println("x is not zero");

        if (x % 2 == 0); { // incorrect semicolon
            System.out.println("x is even");
        }
    }

}
