import java.util.*;

public class bubble {
    public static void main(String[] args) {

    }

    // TC - O(N^2) SC - O(1)

    public static int[] bubbleSort(int[] array) {
        // If length of array is zero then return it as it is
        if (array.length == 0) {
            return array;
        }
        // We use this flag to optimize the algorithm
        boolean isSorted = false;

        // We iterate through the array n-1 times and in every iteration we bring the
        // biggest number to the right
        for (int i = 0; i < array.length - 1; i++) {
            // Make isSorted true
            isSorted = true;
            // Iterate over the array get the biggest number to the right of the unsorted
            // array
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] >= array[j + 1]) {
                    swap(array, j, j + 1);
                    // If any time a swapping occurs mark isSorted as false
                    isSorted = false;
                }
            }

            // If no swapping occurs in a single iteration then the array has been sorted
            if (isSorted) {
                break;
            }
        }
        // return the final sorted array
        return array;
    }

    // Function to swap two numbers in an array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
