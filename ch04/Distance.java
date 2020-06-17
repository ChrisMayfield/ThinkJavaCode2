public class Distance {

    public static double distance1(double x1, double y1, double x2, double y2) {
        return 0.0;  // stub
    }

    public static double distance2(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        System.out.println("dx is " + dx);
        System.out.println("dy is " + dy);
        return 0.0;  // stub
    }

    public static double distance3(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double dsquared = dx * dx + dy * dy;
        System.out.println("dsquared is " + dsquared);
        return 0.0;  // stub
    }

    public static double distance4(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double dsquared = dx * dx + dy * dy;
        double result = Math.sqrt(dsquared);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("\ndistance version 1");
        System.out.println(distance1(1.0, 2.0, 4.0, 6.0));

        System.out.println("\ndistance version 2");
        System.out.println(distance2(1.0, 2.0, 4.0, 6.0));

        System.out.println("\ndistance version 3");
        System.out.println(distance3(1.0, 2.0, 4.0, 6.0));

        System.out.println("\ndistance version 4");
        System.out.println(distance4(1.0, 2.0, 4.0, 6.0));
    }

}
