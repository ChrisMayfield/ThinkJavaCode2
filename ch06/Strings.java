import java.util.Scanner;

/**
 * Demonstrates uses of strings.
 */
public class Strings {

    public static void main(String[] args) {

        // Characters

        String fruit = "banana";
        char letter0 = fruit.charAt(0);

        if (letter0 == 'A') {
            System.out.println("It's an A!");
        }

        System.out.print("Roman alphabet: ");
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.print(c);
        }
        System.out.println();

        System.out.print("Greek alphabet: ");
        for (int i = 913; i <= 937; i++) {
            System.out.print((char) i);
        }
        System.out.println();

        // Which loop to use

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        while (!in.hasNextDouble()) {
            String word = in.next();
            System.err.println(word + " is not a number");
            System.out.print("Enter a number: ");
        }
        double number = in.nextDouble();
        in.nextLine();  // read the newline

        // String iteration

        for (int i = 0; i < fruit.length(); i++) {
            char letter = fruit.charAt(i);
            System.out.println(letter);
        }

        int length = fruit.length();
        char last = fruit.charAt(length - 1);  // correct

        System.out.println(reverse(fruit));

        // The indexOf method

        int index = fruit.indexOf('a');
        int index2 = fruit.indexOf('a', 2);

        // Substrings

        System.out.println(fruit.substring(0, 3));
        System.out.println(fruit.substring(2, 5));
        System.out.println(fruit.substring(6, 6));

        System.out.println(fruit.substring(0));
        System.out.println(fruit.substring(2));
        System.out.println(fruit.substring(6));

        // String comparison

        System.out.print("Play again? ");
        String answer = in.nextLine();
        if (answer == "yes") {                 // wrong!
            System.out.println("Let's go!");
        } else {
            System.out.println("Goodbye!");
        }
        
        if (answer.equals("yes")) {            // correct
            System.out.println("Let's go!");
        }

        String name1 = "Alan Turing";
        String name2 = "Ada Lovelace";
        if (name1.equals(name2)) {
            System.out.println("The names are the same.");
        }

        int diff = name1.compareTo(name2);
        if (diff < 0) {
            System.out.println("name1 comes before name2.");
        } else if (diff > 0) {
            System.out.println("name2 comes before name1.");
        } else {
            System.out.println("The names are the same.");
        }
    }

    /**
     * Reverses a string, returns a new String.
     */
    public static String reverse(String s) {
        String r = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            r = r + s.charAt(i);
        }
        return r;
    }

}
