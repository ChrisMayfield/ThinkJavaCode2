    /**
     * Tests whether x is a single digit integer.
     *
     * @param x the integer to test
     * @return true if x has one digit, false otherwise
     */
    public static boolean isSingleDigit(int x) {
        if (x > -10 && x < 10) {
            return true;
        } else {
            return false;
        }
    }


        System.out.println(isSingleDigit(2));
        boolean bigFlag = !isSingleDigit2(17);

