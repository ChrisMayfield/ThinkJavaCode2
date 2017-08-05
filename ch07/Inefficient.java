/**
 * Version of Doubloon that uses nested loops.
 */
public class Inefficient {
    
    public static boolean isDoubloon(String s) {
        
        // count the number of times each letter appears
        s = s.toLowerCase();
        for (char c = 'a'; c <= 'z'; c++) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    count++;
                }
            }
            
            // determine whether the word is a doubloon
            if (count != 0 && count != 2) {
                return false;  // not a doubloon
            }
        }
        return true;  // all counts were 0 or 2
    }
    
    public static void main(String[] args) {
        System.out.println(isDoubloon("Mama"));
        System.out.println(isDoubloon("Lama"));
    }
    
}
