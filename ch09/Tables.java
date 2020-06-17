/**
 * Encapsulation and generalization.
 */
public class Tables {

    public static void printRow() {
        for (int i = 1; i <= 6; i++) {
            System.out.printf("%4d", 2 * i);
        }
        System.out.println();
    }

    public static void printRow(int n) {
        for (int i = 1; i <= 6; i++) {
            System.out.printf("%4d", n * i);  // generalized n
        }
        System.out.println();
    }

    public static void printTable() {
        for (int i = 1; i <= 6; i++) {
            printRow(i);
        }
    }

    public static void printTable(int rows) {
        for (int i = 1; i <= rows; i++) {     // generalized rows
            printRow(i);
        }
    }

    public static void printRow(int n, int cols) {
        for (int i = 1; i <= cols; i++) {     // generalized cols
            System.out.printf("%4d", n * i);
        }
        System.out.println();
    }

    public static void printTable2(int rows) {
        for (int i = 1; i <= rows; i++) {
            printRow(i, rows);
        }
    }

    public static void main(String[] args) {
        System.out.println("\nprintRow()");
        printRow();

        System.out.println("\nprintRow(6)");
        printRow(6);

        System.out.println("\nprintTable()");
        printTable();

        System.out.println("\nprintTable(6)");
        printTable(6);

        System.out.println("\nprintRow(6, 6)");
        printRow(6, 6);

        System.out.println("\nprintTable2(6)");
        printTable2(6);
    }

}
