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
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int[] res = new int[2];
        int minDiff = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while(i<arrayOne.length && j<arrayTwo.length){
            int diff = Math.abs(arrayOne[i]-arrayTwo[j]);
            if(diff<minDiff){
                minDiff = diff;
                res[0] = arrayOne[i];
                res[1] = arrayTwo[j];
                    
                if(minDiff == 0){
                    return res;
                }
            }
            else if(arrayOne[i]<arrayTwo[j]){
                i++;
            }
            else{
                j++;
            }
        }
        return res;
      }    
}
