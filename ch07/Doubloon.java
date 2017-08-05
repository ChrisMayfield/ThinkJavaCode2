/**
 * Example from the end of Chapter 7.
 */
public class Doubloon {
    
    public static boolean isDoubloon(String s) {
        
        // count the number of times each letter appears
        int[] counts = new int[26];
        String lower = s.toLowerCase();
        for (char letter : lower.toCharArray()) {
            int index = letter - 'a';
            counts[index]++;
        }
        
        // determine whether the given word is a doubloon
        for (int count : counts) {
            if (count != 0 && count != 2) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(isDoubloon("Mama"));
        System.out.println(isDoubloon("Lama"));
    }
    
}
