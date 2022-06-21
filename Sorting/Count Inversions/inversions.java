public class inversions {
    public static void main(String[] args) {

    }

    // Main Function to be called
    public int countInversions(int[] array) {
        return count(array, 0, array.length - 1);
    }

    // TC - O(NLOGN) SC - O(N)
    // WORST TC - O(N^2) SC - O(N)
    // Similiar to Merge Sort Algo
    public static int count(int[] array, int start, int end) {
        // Initialize inversion count
        int invCount = 0;

        // if array size > 1 then only continue
        if (start < end) {
            // calculate mid point
            int mid = start + (end - start) / 2;
            // call count function on the left half
            invCount += count(array, start, mid);
            // call count function on the right half
            invCount += count(array, mid + 1, end);
            // merge both the half and again count the inversions
            invCount += merge(array, start, mid, end);
        }
        // return final inversion count
        return invCount;
    }

    public static int merge(int[] array, int start, int mid, int end) {
        // initialize the pointers to traverse both the left and right array
        int i = start, j = mid + 1, k = 0;
        // initialize temp array to store the sorted array
        int[] temp = new int[end - start + 1];
        // initialize inversion count for merging process
        int invCount = 0;

        // traverse both the arrays
        while (i <= mid && j <= end) {
            // If element of left array is smaller, just push it in temp array and increment
            // pointer. No inversion here
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            }
            // If right element is smaller then we will have an inversion with all the
            // reamining elements of the left array
            // including the current left array element
            else if (array[i] > array[j]) {
                // Store the right array element and increment pointer
                temp[k++] = array[j++];
                // Increment the inversions
                invCount += (mid + 1) - (i);
            }
        }

        // Copy the rest of the left array in temp
        while (i <= mid) {
            temp[k++] = array[i++];
        }

        // Copy the rest of the right array in temp
        while (j <= end) {
            temp[k++] = array[j++];
        }

        // Copy all the elements back to original array
        k = 0;
        for (i = start; i <= end; i++) {
            array[i] = temp[k++];
        }

        // return the final inversion count
        return invCount;
    }
}