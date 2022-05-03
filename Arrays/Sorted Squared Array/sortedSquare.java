import java.util.*;

public class sortedSquare {
    public static void main(String[] args) {
        
    }

    //TC - O(N)   SC - O(N)
    //Main array is sorted. We take advantage of this fact. To reduce the time complexity of the algorithm,
    //we need to avoid sorting the output array. To do this, as we square the values of the input array , 
    //we need to directly insert them into their corect position in the output array. 
    //We use two pointers to keep track of smallest and largest absolute value in the main array. We compare
    // the values of squares of larger and smallest values and place the larger result at the end of output 
    //array, filling it up from left to right. 
      public int[] sortedSquaredArray(int[] array) {
            //We fill the resultant array from left to right. Maintain two pointers pointing to start and end of given array.
            int start = 0, end = array.length-1, idx=array.length-1;
            int[] res = new int[array.length];
            //Find the square of value at the pointers and insert the maximum of two in the result array
            while(start<=end){
                //Square both the values at pointers
                int startSQ = array[start]*array[start];
                int endSQ = array[end]*array[end];
                
                //Insert the max value in res array and increment/decrement the start/end pointer
                if(startSQ>endSQ){
                    res[idx--]=startSQ;
                    start++;
                }else{
                    res[idx--]=endSQ;
                    end--;
                }
            }
        //Return the final result  
        return res;
      }
}
