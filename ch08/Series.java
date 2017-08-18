/**
 * Examples from Chapter 8.
 */
public class Series {

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int recurse = factorial(n - 1);
        int result = n * recurse;
        return result;
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {

        System.out.println("factorial");
        System.out.println(factorial(3));

        System.out.println("fibonacci");
        System.out.println(fibonacci(3));
    }

}
