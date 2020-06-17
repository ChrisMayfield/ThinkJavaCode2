import java.math.BigInteger;

/**
 * BigInteger examples.
 */
public class BigInt {

    public static void main(String[] args) {
        long x = 17;
        BigInteger big = BigInteger.valueOf(x);

        String s = "12345678901234567890";
        BigInteger bigger = new BigInteger(s);

        BigInteger a = BigInteger.valueOf(17);
        BigInteger b = BigInteger.valueOf(1700000000);
        BigInteger c = a.add(b);
    }

}
