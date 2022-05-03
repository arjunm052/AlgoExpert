import java.util.*;

public class small {
    public static void main(String[] args) {
        
    }

    //TC - O(NLOGN)   SC - O(N)
    //Start by sorting both arrays. Put a pointer at start of both and evaluate the absolute difference.
    // If diff is equal to zero return the pair of numbers. Else Increment the pointer of the smaller number,
    // and continue till you find a pair with 0 diff or until one of the pointer goes out of array.
    //Then just return the res. 
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        //Sort both the arrays
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        //Initialize result array
        int[] res = new int[2];

        //mindiff Maintains the minimum difference that we have obtained yet
        int minDiff = Integer.MAX_VALUE;
        //Initialize two pointers to start of each array
        int i = 0, j = 0;

        //While we have not exhausted all the elements of any array find the min diff of elements at the two pointers
        //and compare it with our current result. Update the current result if current difference is less than minDiff
        while(i<arrayOne.length && j<arrayTwo.length){
            int diff = Math.abs(arrayOne[i]-arrayTwo[j]);
            if(diff<minDiff){
                minDiff = diff;
                res[0] = arrayOne[i];
                res[1] = arrayTwo[j];
                  
                //If we find mindiff to be 0 at any point, we just return that pair.
                if(minDiff == 0){
                    return res;
                }
            }
            //Otherwise store the minDiff and just increment the pointer of the smaller number
            else if(arrayOne[i]<arrayTwo[j]){
                i++;
            }
            else{
                j++;
            }
        }

        //Return the final result
        return res;
    }     
}
