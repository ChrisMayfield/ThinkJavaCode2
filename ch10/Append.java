import java.util.Scanner;
public class Append {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 10 lines:");
        String text = "";
        for (int i = 0; i < 10; i++) {
            String line = in.nextLine();        // new string
            text = text + line + '\n';    // two more strings
        }
        System.out.print("You entered:\n" + text);
    }
}
