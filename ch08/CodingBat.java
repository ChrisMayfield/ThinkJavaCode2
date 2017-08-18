/**
 * CodingBat examples from Chapter 8.
 */
public class CodingBat {

    public static String noX(String str) {
        if (str.length() == 0) {
            return "";
        }
        char c = str.charAt(0);
        if (c == 'x') {
            return noX(str.substring(1));
        } else {
            return c + noX(str.substring(1));
        }
    }

    public int array11(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (nums[index] == 11) {
            return 1 + array11(nums, index + 1);
        } else {
            return array11(nums, index + 1);
        }
    }

}
