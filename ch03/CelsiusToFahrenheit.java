import java.util.Scanner;

public class CelsiusToFahrenheit {

    public static void main(String[] args) {
        // Create variables
        double celsius;
        double fahrenheit;
        final int FREEZING_TEMP = 32;
        Scanner input = new Scanner(System.in);

        // Ask for number in celsius, then save that input as the celsius variable
        System.out.print("Enter a temperature in Celsius: ");
        celsius = input.nextDouble();
        System.out.printf("%.1f celsius\n", celsius);

        // Conver celsius to fahrenheit 
        fahrenheit = (celsius * 9.0/5.0) + (FREEZING_TEMP);

        // Display result!
        System.out.printf("%.1f celsius = %.1f fahrenheit\n", celsius, fahrenheit);



    }


}