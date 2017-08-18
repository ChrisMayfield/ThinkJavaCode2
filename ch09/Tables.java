/**
 * Encapsulation and generalization.
 */
public class Tables {

    public static void printRow() {
        int i = 1;
        while (i <= 6) {
            System.out.printf("%4d", 2 * i);
            i = i + 1;
        }
        System.out.println();
    }

    public static void printRow(int n) {
        int i = 1;
        while (i <= 6) {
            System.out.printf("%4d", n * i);  // generalized n
            i = i + 1;
        }
        System.out.println();
    }

    public static void printTable() {
        int i = 1;
        while (i <= 6) {
            printRow(i);
            i = i + 1;
        }
    }

    public static void printTable(int rows) {
        int i = 1;
        while (i <= rows) {  // generalized rows
            printRow(i);
            i = i + 1;
        }
    }

    public static void printRow(int n, int cols) {
        int i = 1;
        while (i <= cols) {  // generalized cols
            System.out.printf("%4d", n * i);
            i = i + 1;
        }
        System.out.println();
    }

    public static void printTable2(int rows) {
        int i = 1;
        while (i <= rows) {
            printRow(i, rows);  // added rows argument
            i = i + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println("printRow()");
        printRow();

        System.out.println("printRow(6)");
        printRow(6);

        System.out.println("printTable()");
        printTable();

        System.out.println("printTable(6)");
        printTable(6);

        System.out.println("printRow(6, 6)");
        printRow(6, 6);

        System.out.println("printTable2(6)");
        printTable2(6);
    }

}
