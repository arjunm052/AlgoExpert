public class heap {
    public static void main(String[] args) {

    }

    // TC - O(NlogN)
    // SC - O(logN)
    public static int[] heapSort(int[] array) {
        // First turn the complete array into a max heap
        // Loop through all the internal nodes from right to left, and apply heapify on
        // each on of them
        // Internal nodes are from 0 to array.length/2 - 1
        for (int i = array.length - 2 / 2; i >= 0; i--) {
            heapify(array, i, array.length - 1);
        }

        // Pop the max element and place at the end of the heap, decrease the size of
        // heap and heapify the unsorted portion again
        for (int i = array.length - 1; i > 0; i--) {
            // swap the max element by last element of heap
            swap(array, 0, i);
            // shorten the size of heap and heapify it again
            heapify(array, 0, i - 1);
        }

        // Return the final sorted array
        return array;
    }

    // Heapify Method that builds up the max heap
    public static void heapify(int[] array, int curr, int size) {
        // curr is the index of element that is to be heapified
        // largest will hold the index of largest element between curr, it's left and
        // right child
        int largest = curr;
        // left denoted the index of left child of curr element if it exists
        int left = 2 * curr + 1;
        // right denoted the index of right child of curr element if it exists
        int right = 2 * curr + 2;

        // If left child exists and is greater than curr element then update largest
        // with its index
        if (left <= size && array[left] > array[curr]) {
            largest = left;
        }
        // Else the largest wil be the curr index only
        else {
            largest = curr;
        }

        // Now compare right child of curr if exists with the element at largest index
        if (right <= size && array[right] > array[largest]) {
            largest = right;
        }

        // If largest is not equal to curr then it means we have found a larger element
        // at child index of curr
        if (largest != curr) {
            // Swap the child with the curr index element
            swap(array, curr, largest);
            // and again heapify the
            heapify(array, largest, size);
        }
    }

    // Function to swap two elements in an array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
