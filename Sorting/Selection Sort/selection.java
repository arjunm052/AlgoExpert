import java.util.*;

public class selection {
    public static void main(String[] args) {

    }

    // TC - O(N^2) SC - O(N)

    public static int[] selectionSort(int[] array) {
        // Base case
        if (array.length == 0 || array.length == 1) {
            return array;
        }

        // Initalize the start index
        int startIndex = 0;
        // we iterate the array n-1 times because if n-1 numbers are sorted, then the
        // Nth number will be sorted as well
        while (startIndex < array.length - 1) {
            // Set the smallestIndex to the current number
            int smallestIndex = startIndex;
            // Traverse the rest of the array and find the smallest number
            for (int i = startIndex + 1; i < array.length; i++) {
                // If found then update the smallest index
                if (array[i] < array[smallestIndex]) {
                    smallestIndex = i;
                }
            }
            // Swap the smallest index number with starting index
            swap(array, startIndex, smallestIndex);
            // Increment the starting index
            startIndex++;
        }

        // Return the sorted array
        return array;
    }

    // Function to swap two numbers in an array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}