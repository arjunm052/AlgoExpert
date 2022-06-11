public class merge {
    public static void main(String[] args) {

    }

    public static int[] mergeSort(int[] array) {
        // Write your code here.
        sort(array, 0, array.length - 1);
        return array;
    }

    //TC - O(NLOGN)  SC - O(N)

    //Function to split the array into two equal halves and recursively sort them
    public static void sort(int[] array, int start, int end) {
        if (start < end) {
            //Find mid and call mergeSort function for both left half and right half
            int mid = start + (end - start) / 2;
            sort(array, start, mid);
            sort(array, mid + 1, end);
            //Merge the two sorted arrays
            merge(array, start, mid, end);
        }
    }

    public static void merge(int[] array, int start, int mid, int end) {
        //Initialize start pointers for both the arrays
        int i = start, j = mid + 1, k = 0;
        //Initialize the temp array
        int temp[] = new int[end - start + 1];

        //Traverse both the arrays  and store no.s in temp array in sorted order
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        //Get all the remaining no.s from left array
        while (i <= mid) {
            temp[k++] = array[i++];
        }

        //Get all the remaining no.s from right array
        while (j <= end) {
            temp[k++] = array[j++];
        }

        //Copy all the no.s fro temp array to orignal array
        k = 0;
        for (i = start; i <= end; i++) {
            array[i] = temp[k++];
        }

    }

    // Function to swap two numbers in an array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
