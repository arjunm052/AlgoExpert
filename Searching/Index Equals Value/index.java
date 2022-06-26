public class index {
    public static void main(String[] args) {

    }

    // TC - O(logN) SC - O(1)
    public int indexEqualsValue(int[] array) {
        // Initialize the star and end pointers and result variable
        int start = 0, end = array.length - 1;
        int res = -1;

        // while start is less than or equal to end
        while (start <= end) {
            // get the mid index
            int mid = start + (end - start) / 2;

            // If current element is equal to its index then we store it as a result and
            // keep looking on the left side
            if (array[mid] == mid) {
                // store the result
                res = mid;
                // update end pointer
                end = mid - 1;
            }
            // If index is greater than the element then we have to look on the right side
            else if (mid > array[mid]) {
                start = mid + 1;
            }
            // if index is smaller than the element then we have to look on the left side
            else if (array[mid] > mid) {
                end = mid - 1;
            }

        }

        // return the final result
        return res;
    }
}
