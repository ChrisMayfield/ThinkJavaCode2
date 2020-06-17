import java.util.Scanner;

/**
 * Converts inches to centimeters.
 */
public class Literals {

    public static void main(String[] args) {
        int inch;
        double cm;
        Scanner in = new Scanner(System.in);

        System.out.print("How many inches? ");
        inch = in.nextInt();

        final double CM_PER_INCH = 2.54;
        cm = inch * CM_PER_INCH;
        System.out.print(inch + " in = ");
        System.out.println(cm + " cm");
    }

}
