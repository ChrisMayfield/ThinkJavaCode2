import java.util.Scanner;

/**
 * Converts centimeters to feet and inches.
 */
public class Convert {

    public static void main(String[] args) {
        double cm;
        int feet, inches, remainder;
        final double CM_PER_INCH = 2.54;
        final int IN_PER_FOOT = 12;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter 1 to convert centimeters to feet and inches\n"
                         + "Enter 2 to convert feet and inches to centimeters\n"
                         + "Your choice: ");

        int choice = in.nextInt();

        if (choice == 1) {
            System.out.print("Exactly how many cm? ");
            cm = in.nextDouble();

            if (cm < 0) {
                System.out.print("Please enter a positive value for centimeters.");
            } else {
                inches = (int) (cm / CM_PER_INCH);
                feet = inches / IN_PER_FOOT;
                remainder = inches % IN_PER_FOOT;
                inches = inches - (feet * IN_PER_FOOT);
                System.out.printf("%.2f cm = %fd ft, %d in\n", cm, feet, inches);
            }
        } else if (choice == 2); {
            System.out.print("Enter feet: ");
            feet = in.nextInt();
            System.out.print("Enter inches: ");
            inches = in.nextInt();

            if (feet < 0 || inches < 0 || inches >= IN_PER_FOOT) {
                System.out.println("Please enter valid and positive values for feet and inches.");
            }
        }

        // prompt the user and get the value
        System.out.print("Exactly how many cm? ");
        cm = in.nextDouble();

        // convert and output the result
        inches = (int) (cm / CM_PER_INCH);
        feet = inches / IN_PER_FOOT;
        remainder = inches % IN_PER_FOOT;
        System.out.printf("%.2f cm = %d ft, %d in\n",
                          cm, feet, remainder);
    }

}
