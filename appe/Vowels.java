/**
 * Example switch statement with cases that fall through.
 */
public class Vowels {

    public static void main(String[] args) {
        String s = "Ahoy!";
        for (int i = 0; i < s.length(); i++) {

            // display the next character
            char c = s.charAt(i);
            System.out.print(c + " is a ");

            // if capital, convert to lowercase
            if (c >= 'A' && c <= 'Z') {
                c += 'a' - 'A';
            }

            // check if not a lowercase letter
            if (c < 'a' || c > 'z') {
                System.out.println("symbol");
                continue;
            }

            // output the result of the letter
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.println("vowel");
                    break;

                case 'y':
                    System.out.println("not sure");
                    break;

                default:
                    System.out.println("consonant");
                    break;
            }
        }
    }

}
