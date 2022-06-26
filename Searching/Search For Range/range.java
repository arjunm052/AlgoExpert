public class range {
    public static void main(String[] args) {

    }

    // TC - O(logN) SC - O(1)
    // Function that return the range of an element in a sorted array
    public static int[] searchForRange(int[] array, int target) {
        // Get the first occurence of the target element
        int first = firstOccurence(array, target);
        // Gett the last occurence of the target element
        int last = lastOccurence(array, target);

        // If the target element is not present then return {-1,-1}
        if (first == -1) {
            return new int[] { -1, -1 };
        }

        // else return the range of the target element
        return new int[] { first, last };
    }

    // Function to calculate the first occurence of an element in a sorted array if
    // it exists
    public static int firstOccurence(int[] array, int target) {
        // Initialize start,end pointers, and result variable
        int start = 0, end = array.length - 1;
        int res = -1;

        // While start is less than end
        while (start <= end) {
            // calculate the mid index
            int mid = start + (end - start) / 2;

            // If target element is present at mid index, then store this index as a result,
            // and recursively search for the target element on the left part of the array
            if (array[mid] == target) {
                res = mid;
                end = mid - 1;
            }

            // If target element is greater than element at mid index, search on the right
            // part of the array
            else if (target > array[mid]) {
                start = mid + 1;
            }
            // If target is smaller than element at mid index then search in left part of
            // the array
            else {
                end = mid - 1;
            }

        }
        // return the final result
        return res;
    }

    // This function has exactly same functionality as above. The only difference
    // is, when we do find the target element, to get its last occurence we update
    // the result variable and search the right part of the array again for the
    // target element
    public static int lastOccurence(int[] array, int target) {
        int start = 0, end = array.length - 1;
        int res = -1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (array[mid] == target) {
                res = mid;
                start = mid + 1;
            }

            else if (target > array[mid]) {
                start = mid + 1;
            }

            else {
                end = mid - 1;
            }
        }
        return res;
    }
}
