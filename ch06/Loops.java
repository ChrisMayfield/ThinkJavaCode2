/**
 * Examples from Chapter 6.
 */
public class Loops {

    public static void countdown(int n) {
        while (n > 0) {
            System.out.println(n);
            n = n - 1;
        }
        System.out.println("Blastoff!");
    }

    public static void sequence(int n) {
        while (n != 1) {
            System.out.println(n);
            if (n % 2 == 0) {         // n is even
                n = n / 2;
            } else {                  // n is odd
                n = n * 3 + 1;
            }
        }
    }

    public static void plusplus() {
        int i = 1;
        while (i <= 5) {
            System.out.println(i);
            i++; // add 1 to i
        }
    }

    public static void appreciate() {
        int i = 2;
        while (i <= 8) {
            System.out.print(i + ", ");
            i += 2; // add 2 to i
        }
        System.out.println("Who do we appreciate?");
    }

    public static void loopvar() {
        int n;
        for (n = 3; n > 0; n--) {
            System.out.println(n);
        }
        System.out.println("n is now " + n);
    }

    public static void nested() {
        for (int x = 1; x <= 10; x++) {
            for (int y = 1; y <= 10; y++) {
                System.out.printf("%4d", x * y);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("countdown");
        countdown(3);

        System.out.println("sequence");
        sequence(10);

        System.out.println("plusplus");
        plusplus();

        System.out.println("appreciate");
        appreciate();

        System.out.println("loopvar");
        loopvar();

        System.out.println("nested");
        nested();
    }

}
