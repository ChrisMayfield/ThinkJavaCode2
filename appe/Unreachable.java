public class Unreachable {

    public static double absoluteValue(double x) {
        if (x < 0) {
            return -x;
        } else {
            return x;
        }
    }

    public static void main(String[] args) {
        System.out.println("absolute value");
        System.out.println(absoluteValue(-2));
    }

}
