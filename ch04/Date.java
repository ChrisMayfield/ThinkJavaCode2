
public class Date {

    public static void printAmerican(int date, int year, String day, String month) {
        System.out.print("American format for date: ");
        System.out.print(day);
        System.out.print(", ");
        System.out.print(month);
        System.out.print(" ");
        System.out.print(date);
        System.out.print(", ");
        System.out.println(year);


    }

    public static void main (String[] args) {
        int date = 11;
        int year = 1993;
        String day = "Monday";
        String month = "April";
        printAmerican(date, year, day, month);
        
    }

}

