import java.util.*;

public class insertion {
    public static void main(String[] args) {

    }

    // TC - O(N^2) SC - O(1)

    public static int[] insertionSort(int[] array) {
        // Base case
        if (array.length == 0 || array.length == 1) {
            return array;
        }
        // We assume array[0..i-1] is always sorted and rest of the array is unsorted

        // Traverse the whole array from the 1st index
        for (int i = 1; i < array.length; i++) {
            // Initialize j and key variable
            int j = i - 1;
            int key = array[i];

            // Compare all the elements and find correct position of key in the sorted array
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            // Insert the key at its correct position
            array[j + 1] = key;
        }

        // return the sorted array
        return array;
    }
}
