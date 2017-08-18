/**
 * Generating tables.
 */
public class Tables {

    public static void example() {
        int i = 1;
        while (i < 10) {
            double x = i;
            System.out.println(x + "   " + Math.log(x));
            i = i + 1;
        }
    }

    public static void example2() {
        int i = 1;
        while (i < 10) {
            double x = i;
            System.out.println(x + "   " + Math.log(x) / Math.log(2));
            i = i + 1;
        }
    }

    public static void example3() {
        final double LOG2 = Math.log(2);
        int i = 1;
        while (i < 100) {
            double x = i;
            System.out.println(x + "   " + Math.log(x) / LOG2);
            i = i * 2;
        }
    }

    public static void main(String[] args) {
        System.out.println("example");
        example();

        System.out.println("example2");
        example2();

        System.out.println("example3");
        example3();
    }

}
