/**
 * Represents a time of day.
 */
public class Time {

    private int hour;
    private int minute;
    private double second;

    /**
     * Construct a Time object with default values.
     */
    public Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0.0;
    }

    /**
     * Construct a Time object with given values.
     */
    public Time(int hour, int minute, double second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public double getSecond() {
        return this.second;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setSecond(double second) {
        this.second = second;
    }

    /**
     * Prints the time in a simple format.
     */
    public static void printTime(Time t) {
        System.out.print(t.hour);
        System.out.print(":");
        System.out.println(t.minute);
        System.out.print(":");
        System.out.println(t.second);
    }

    /**
     * Returns a String representation of the time.
     */
    public String toString() {
        return String.format("%02d:%02d:%04.1f\n",
            this.hour, this.minute, this.second);
    }

    /**
     * Tests whether two times are equivalent.
     */
    public boolean equals(Time that) {
        final double DELTA = 0.001;
        return this.hour == that.hour
            && this.minute == that.minute
            && Math.abs(this.second - that.second) < DELTA;
    }

    /**
     * Adds two Times and returns a new Time object (static method).
     */
    public static Time add(Time t1, Time t2) {
        Time sum = new Time();
        sum.hour = t1.hour + t2.hour;
        sum.minute = t1.minute + t2.minute;
        sum.second = t1.second + t2.second;
        return sum;
    }

    /**
     * Adds two Times and returns a new Time object (instance method).
     */
    public Time add(Time t2) {
        Time sum = new Time();
        sum.hour = this.hour + t2.hour;
        sum.minute = this.minute + t2.minute;
        sum.second = this.second + t2.second;

        if (sum.second >= 60.0) {
            sum.second -= 60.0;
            sum.minute += 1;
        }
        if (sum.minute >= 60) {
            sum.minute -= 60;
            sum.hour += 1;
        }
        if (sum.hour >= 24) {
            sum.hour -= 24;
        }
        return sum;
    }

}
