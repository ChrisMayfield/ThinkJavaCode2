public class LogicalOpers {

    public static void main(String[] args) {
        int x = 0;
        int y = 0;

        // nested
        if (x == 0) {
            if (y == 0) {
                System.out.println("Both x and y are zero");
            }
        }

        // combined
        if (x == 0 && y == 0) {
            System.out.println("Both x and y are zero");
        }

        // chained
        if (x == 0) {
            System.out.println("Either x or y is zero");
        } else if (y == 0) {
            System.out.println("Either x or y is zero");
        }

        // combined
        if (x == 0 || y == 0) {
            System.out.println("Either x or y is zero");
        }

        // De Morgan's
        if (!(x == 0 || y == 0)) {
            System.out.println("Neither x nor y is zero");
        }
        if (x != 0 && y != 0) {
            System.out.println("Neither x nor y is zero");
        }

        // boolean variables
        boolean flag;
        flag = true;
        boolean testResult = false;

        boolean evenFlag = (x % 2 == 0);    // true if x is even
        boolean positiveFlag = (x > 0);     // true if x is positive

        if (evenFlag) {
            System.out.println("n was even when I checked it");
        }

        if (!evenFlag) {
            System.out.println("n was odd when I checked it");
        }
    }

}
