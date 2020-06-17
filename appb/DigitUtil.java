/**
 * Utility class for extracting digits from integers.
 *
 * @author Chris Mayfield
 * @version 1.0
 */
public class DigitUtil {

    /**
     * Tests whether x is a single digit integer.
     *
     * @param x the integer to test
     * @return true if x has one digit, false otherwise
     */
    public static boolean isSingleDigit(int x) {
        return x > -10 && x < 10;
    }

    public static void main(String[] args) {
        System.out.println(isSingleDigit(2));

        boolean bigFlag = !isSingleDigit(17);
        if (bigFlag) {
            System.out.println("not single");
        }

        int z = 9;
        if (isSingleDigit(z)) {
            System.out.println("z is small");
        } else {
            System.out.println("z is big");
        }
    }

}
