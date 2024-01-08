import java.util.Scanner;

/**
 * Inputs two lines and repeats them back to the user.
 */
public class Echo {

    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);

        System.out.print("Type something: ");
        line = in.nextLine();
        System.out.println("You said: " + line);

        System.out.print("Type something else: ");
        line = in.nextLine();
        System.out.println("You then said: " + line);

        System.out.print("One more time please: ");
        line = in.nextLine();
        System.out.println("I totally agree with " + line);
    }

}
