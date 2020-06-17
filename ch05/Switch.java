public class Switch {

    public static void main(String[] args) {
        int number = 0;
        String word;

        // if-else-if

        if (number == 1) {
            word = "one";
        } else if (number == 2) {
            word = "two";
        } else if (number == 3) {
            word = "three";
        } else {
            word = "unknown";
        }

        // same result as above

        switch (number) {
            case 1:
                word = "one";
                break;
            case 2:
                word = "two";
                break;
            case 3:
                word = "three";
                break;
            default:
                word = "unknown";
                break;
        }

        System.out.print(number);
        System.out.print(word);

        // switch blocks fall through

        String food = "apple";
        switch (food) {
            case "apple":
            case "banana":
            case "cherry":
                System.out.println("Fruit!");
                break;
            case "asparagus":
            case "broccoli":
            case "carrot":
                System.out.println("Vegetable!");
                break;
        }
    }

}
