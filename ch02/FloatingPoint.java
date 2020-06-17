public class FloatingPoint {

    public static void main(String[] args) {
        double pi;
        pi = 3.14159;

        double minute3 = 59.0;
        System.out.print("Fraction of the hour that has passed: ");
        System.out.println(minute3 / 60.0);

        double y = 1.0 / 3.0;  // correct

        System.out.println(0.1 * 10);
        System.out.println(0.1 + 0.1 + 0.1 + 0.1 + 0.1
                         + 0.1 + 0.1 + 0.1 + 0.1 + 0.1);

        double balance = 123.45;  // potential rounding error
        int balance2 = 12345;     // total number of cents
    }

}
