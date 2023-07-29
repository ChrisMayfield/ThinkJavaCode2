public class Merge {
    public static void main(String[] args) {

        // Test cases
        int[] arr1 = { 1, 3, 5 };
        int[] arr2 = { 2, 4, 6, 8 };

        // Call the merge function to combine the two arrays
        int[] mergedArray = merge(arr1, arr2);

        // Display the merged array
        System.out.println("Merged Array:");
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
    }

    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
             // Place elements from array 'a' at even indices in the result array
            result[2 * i] = a[i];

            // Check if there's a corresponding element in array 'b' to place at odd index
            if (i < b.length) {
                result[2 * i + 1] = b[i];
            }
        }
        // If array b is longer than array a, add the remaining elements of b
        for (int i = a.length; i < b.length; i++) {
            result[2 * i] = b[i];
        }
        return result;
    }
}

