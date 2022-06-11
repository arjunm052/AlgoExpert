public class quick {
    public static void main(String[] args) {

    }

    public static int[] quickSort(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return array;
        }
        quick(array, 0, array.length - 1);
        return array;
    }

    //Average/Best TC - O(NLOGN)   SC - O(1)
    //Worst TC - O(N^2) - O(1)   Not considering the stack space


    //Recursive function for quicksort
    public static void quick(int[] array, int start, int end) {
        if (start < end) {
            //Find the index of pivot element
            int pivot = partition(array, start, end);
            //Recursively call quicksort on left side and right side of pivot element.
            quick(array, start, pivot - 1);
            quick(array, pivot + 1, end);
        }
    }

    //Parition Function that returns the index of pivot element
    public static int partition(int[] array, int start, int end) {
        //We select the pivot element as last element
        int pivot = array[end];
        //This variable will help us to swap elements that are smalles than pivot
        int i = start - 1;


        //Traverse the whole array and swap the elements with i+1th index that are smaller than  pivot
        for (int j = start; j < end; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        //Place the pivot in its correct position
        swap(array, i + 1, end);
        //return the index of pivot element
        return i + 1;
    }

    // Function to swap two numbers in an array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
