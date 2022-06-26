public class quick {
    public static void main(String[] args) {

    }

    // NOTE - *** Make Sure not to forget the return statements in Conditonal checks
    // ***
    // TC -> Best O(N) Worst O(N^2) SC - O(1)
    // Main function to call for Quick Select
    public static int quickselect(int[] array, int k) {
        return utilFunction(array, 0, array.length - 1, k - 1);
    }

    // Function that returns Kth Smallest Element
    public static int utilFunction(int[] array, int start, int end, int k) {
        // If array has single element, then return that element as result
        if (start == end) {
            return array[start];
        }

        // initialize result
        int res = -1;

        // Get the pivot index by calling parition method
        int pivot = partition(array, start, end);

        // If pivot is equal to k then we have found the Kth Smallest Element
        if (pivot == k) {
            // Store the element as the result
            res = array[pivot];
        }

        // If k is smaller than pivot then we search on the left portion of pivot
        else if (k < pivot) {
            return utilFunction(array, start, pivot - 1, k);
        }
        // if k is greater than pivot then we search on right side of pivot
        else if (k > pivot) {
            return utilFunction(array, pivot + 1, end, k);
        }
        // return the final result
        return res;
    }

    public static int partition(int[] array, int start, int end) {
        // We select the pivot element as last element
        int pivot = array[end];
        // This variable will help us to swap elements that are smalles than pivot
        int i = start - 1;

        // Traverse the whole array and swap the elements with i+1th index that are
        // smaller than pivot
        for (int j = start; j < end; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        // Place the pivot in its correct position
        swap(array, i + 1, end);
        // return the index of pivot element
        return i + 1;
    }

    // Function to swap two numbers in an array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
