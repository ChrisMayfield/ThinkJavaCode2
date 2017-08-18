import java.math.BigInteger;

/**
 * Demonstates uses of objects and wrappers.
 */
public class Objects {

    public static void main(String[] args) {

        // primitives vs objects

        int number = -2;
        char symbol = '!';
        char[] array = {'c', 'a', 't'};
        String word = "dog";

        // Strings are immutable

        String name = "Alan Turing";
        String upperName = name.toUpperCase();

        String text = "Computer Science is fun!";
        text = text.replace("Computer Science", "CS");

        // Wrapper classes

        Integer x = new Integer(123);
        Integer y = new Integer(123);
        if (x == y) {                           // false
            System.out.println("x and y are the same object");
        }
        if (x.equals(y)) {                      // true
            System.out.println("x and y have the same value");
        }

        String str = "12345";
        int num = Integer.parseInt(str);

        num = 12345;
        str = Integer.toString(num);

        // BigInteger arithmetic

        long z = 17;
        BigInteger big = BigInteger.valueOf(z);

        String s = "12345678901234567890";
        BigInteger bigger = new BigInteger(s);

        BigInteger a = BigInteger.valueOf(17);
        BigInteger b = BigInteger.valueOf(1700000000);
        BigInteger c = a.add(b);
    }

}
