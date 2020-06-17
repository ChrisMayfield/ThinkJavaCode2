/**
 * Examples from the middle of the chapter.
 */
public class Formatting {

    public static void main(String[] args) {
        final double CM_PER_INCH = 2.54;

        System.out.println(System.out);

        // formatting output

        System.out.print(4.0 / 3.0);
        System.out.printf("Four thirds = %.3f", 4.0 / 3.0);

        int inch = 100;
        double cm = inch * CM_PER_INCH;
        System.out.printf("%d in = %f cm\n", inch, cm);

        // type cast operators

        double pi = 3.14159;
        int xi = (int) pi;

        double x = (int) pi * 20.0;  // result is 60.0, not 62.0

        inch = (int) (cm / CM_PER_INCH);
        System.out.printf("%f cm = %d in\n", cm, inch);

        System.out.printf("inches = %d" + inch);  // error
    }

}
