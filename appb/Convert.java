/*
 * Copyright (c) 2017 Allen Downey and Chris Mayfield
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.util.Scanner;

/**
 * Utility class for converting to/from the metric system.
 *
 * @author Allen Downey
 * @author Chris Mayfield
 * @version 6.1.5
 */
public class Convert {

    public static final double CM_PER_INCH = 2.54;

    public static final int IN_PER_FOOT = 12;

    /**
     * Converts a measurement in centimeters to inches.
     *
     * @param cm length in centimeters
     * @return length in inches
     */
    public static double toImperial(double cm) {
        return cm / CM_PER_INCH;
    }

    /**
     * Converts a length in feet and inches to centimeters.
     *
     * @param feet how many feet
     * @param inches how many inches
     * @return length in centimeters
     */
    public static double toMetric(int feet, int inches) {
        int total = feet * IN_PER_FOOT + inches;
        return total * CM_PER_INCH;
    }

    /**
     * Tests the conversion methods.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        double cm, result;
        int feet, inches;
        Scanner in = new Scanner(System.in);

        // test the Imperial conversion
        System.out.print("Exactly how many cm? ");
        cm = in.nextDouble();
        result = toImperial(cm);
        System.out.printf("That's %.2f inches\n", result);
        System.out.println();

        // test the Metric conversion
        System.out.print("Now how many feet? ");
        feet = in.nextInt();
        System.out.print("And how many inches? ");
        inches = in.nextInt();
        result = toMetric(feet, inches);
        System.out.printf("That's %.2f cm\n", result);
    }
}
