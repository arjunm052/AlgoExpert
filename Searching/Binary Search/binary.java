public class binary {
    public static void main(String[] args) {

    }

    // Function to perform Binary search for an element in a sorted array
    public static int binarySearch(int[] array, int target) {
        // If array length is zero then no element i spresent in array
        if (array.length == 0) {
            return -1;
        }

        // Initialize start and end indexes
        int start = 0;
        int end = array.length - 1;

        // While start is smaller than or equal to end
        while (start <= end) {
            // calculate the mid point between them
            int mid = start + (end - start) / 2;

            // Check if it it is the required target element
            if (array[mid] == target) {
                // if it is then return its index
                return mid;
            }

            // if our target is smaller than mid element then we recursively search on the
            // left by updating end pointer
            if (target < array[mid]) {
                end = mid - 1;
            }
            // else we search on the right by updating start pointer
            else {
                start = mid + 1;
            }
        }

        //return -1 if target element not found
        return -1;
    }
}
