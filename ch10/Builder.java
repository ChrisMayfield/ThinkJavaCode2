import java.util.Scanner;

/*
 * StringBuilder example.
 */
public class Builder {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // less efficient
        System.out.println("Enter 10 lines:");
        
        String slow = "";
        for (int i = 0; i < 10; i++) {
            String line = in.nextLine();        // new string
            slow = slow + line + '\n';    // two more strings
        }
        System.out.print("You entered:\n" + slow);

        // more efficient
        System.out.println("Enter 10 lines:");

        StringBuilder text = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            String line = in.nextLine();
            text.append(line);
            text.append('\n');
        }
        System.out.print("You entered:\n" + text);
        
        String result = text.toString();
    }

}
