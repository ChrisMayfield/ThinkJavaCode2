public class Circle {

    public static double calculateArea(double radius) {
        double result = Math.PI * radius * radius;
        return result;
    }

    public static double calculateArea2(double radius) {
        return Math.PI * radius * radius;
    }

    public static double distance
            (double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        System.out.println("dx is " + dx);
        System.out.println("dy is " + dy);
        return 0.0;
    }

    public static double distance2
            (double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double dsquared = dx * dx + dy * dy;
        System.out.println("dsquared is " + dsquared);
        return 0.0;
    }

    public static double distance3
            (double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double dsquared = dx * dx + dy * dy;
        double result = Math.sqrt(dsquared);
        return result;
    }

    public static double circleArea
            (double xc, double yc, double xp, double yp) {
        double radius = distance(xc, yc, xp, yp);
        double area = calculateArea(radius);
        return area;
    }

    public static double calculateArea
            (double xc, double yc, double xp, double yp) {
        return calculateArea(distance(xc, yc, xp, yp));
    }

    public static void main(String[] args) {

        System.out.println("calculateArea");
        System.out.println(calculateArea(3.0));

        System.out.println("calculateArea2");
        System.out.println(calculateArea2(3.0));

        System.out.println("distance");
        System.out.println(distance(1.0, 2.0, 4.0, 6.0));

        System.out.println("distance2");
        System.out.println(distance2(1.0, 2.0, 4.0, 6.0));

        System.out.println("distance3");
        System.out.println(distance3(1.0, 2.0, 4.0, 6.0));

        System.out.println("circleArea");
        System.out.println(circleArea(1.0, 2.0, 4.0, 6.0));

        System.out.println("calculateArea with 4 doubles");
        System.out.println(calculateArea(1.0, 2.0, 4.0, 6.0));

    }

}
