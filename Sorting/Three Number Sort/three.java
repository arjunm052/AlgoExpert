import java.util.*;

public class three {
    public static void main(String[] args) {

    }

    //TC - O(N)  SC - O(1)
    public int[] threeNumberSort(int[] array, int[] order) {
        //array[0...start-1] will be order[0]
        //array[start....end-1] will be order[1]
        //array[end...n] will be order[2]

        //initialize start,mid,and end
        int start = 0, mid = 0, end = array.length;
        
        while (mid < end) {
            if (array[mid] == order[0]) {
                swap(array, mid, start);
                start++;
                mid++;
            } else if (array[mid] == order[1]) {
                mid++;
            } else {
                end--;
                swap(array, mid, end);
            }
        }
        //Return sorted array
        return array;
    }

    // Function to swap two numbers in an array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
