/**
 * Demonstrates uses of objects and wrappers.
 */
public class Objects {

    public static void main(String[] args) {

        // primitives vs objects

        int number = -2;
        char symbol = '!';
        char[] array = {'c', 'a', 't'};
        String word = "dog";

        String word1 = new String("dog");  // creates a string object
        String word2 = "dog";  // implicitly creates a string object
        
        // the null keyword

        String name0 = null;
        int[] combo = null;
        // System.out.println(name0.length());  // NullPointerException
        // System.out.println(combo[0]);        // NullPointerException

        // Strings are immutable

        String name = "Alan Turing";
        String upperName = name.toUpperCase();

        name.toUpperCase();           // ignores the return value
        System.out.println(name);
        name = name.toUpperCase();    // references the new string
        System.out.println(name);

        String text = "Computer Science is fun!";
        text = text.replace("Computer Science", "CS");

        // Wrapper classes

        Integer i = Integer.valueOf(5);
        System.out.println(i.equals(5));  // displays true

        Integer x = Integer.valueOf(123);
        Integer y = Integer.valueOf(123);
        if (x == y) {                     // false
            System.out.println("x and y are the same object");
        }
        if (x.equals(y)) {                // true
            System.out.println("x and y have the same value");
        }

        String str = "12345";
        int num = Integer.parseInt(str);

        num = 12345;
        str = Integer.toString(num);
    }

}
