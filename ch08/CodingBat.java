/**
 * CodingBat examples from Chapter 8.
 */
public class CodingBat {

    /**
     * See https://codingbat.com/prob/p118230.
     */
    public String noX(String str) {
        if (str.length() == 0) {
            return "";
        }
        char first = str.charAt(0);
        String rest = str.substring(1);
        String recurse = noX(rest);
        if (first == 'x') {
            return recurse;
        } else {
            return first + recurse;
        }
    }

    /**
     * See https://codingbat.com/prob/p135988.
     */
    public int array11(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        int recurse = array11(nums, index + 1);
        if (nums[index] == 11) {
            return recurse + 1;
        } else {
            return recurse;
        }
    }

}
