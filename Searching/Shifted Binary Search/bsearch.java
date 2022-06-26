public class bsearch {
    public static void main(String[] args) {

    }

    // TC - O(logN) SC - O(1)
    public static int shiftedBinarySearch(int[] array, int target) {
        // Initialize start and end pointer
        int start = 0;
        int end = array.length - 1;

        // While start is less than end
        while (start <= end) {
            // calculate the middle index
            int mid = start + (end - start) / 2;

            // if the element at mid index is equal to target element then return its index
            if (array[mid] == target) {
                return mid;
            }

            // We then check for which part of the array is sorted

            // If the left part of the array is sorted
            if (array[start] <= array[mid]) {
                // If the target lies within the left part of the sorted array update the end
                // pointer
                if (target >= array[start] && target <= array[mid]) {
                    end = mid - 1;
                }
                // else update the start pointer
                else {
                    start = mid + 1;
                }
            }

            // If the right part of the array is sorted
            if (array[mid] <= array[end]) {
                // If the element lies within the right sorted array part update the start
                // pointer
                if (target >= array[mid] && target <= array[end]) {
                    start = mid + 1;
                }
                // else update the end pointer
                else {
                    end = mid - 1;
                }
            }
        }

        // return -1 if element not found
        return -1;
    }
}
