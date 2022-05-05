import java.util.*;

public class foursum {
    public static void main(String[] args) {
        
    }

    //TC - O(N^3)    SC - O(N)
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        //Base Case
        if(array.length<4){
                return new ArrayList<Integer[]>();
        }
        //Sort the input array
        Arrays.sort(array);
        //Initialize the resultant array
        List<Integer[]> res = new ArrayList<Integer[]>();
        //We do two for loops to traverse through the array and also use the two pointer approach
        //to find all the quadruplets that sum up to the given targetSum.
        for(int i = 0; i < array.length-3; i++){
            for(int j = i+1; j< array.length-2; j++){
                //Initialize start and end pointers for two pointer approach
                int start = j+1;
                int end = array.length-1;
                //Look for all the pairs that when added with array[i] + array[j] sums up to the targetSum
                while(start<end){
                    int sum = array[i]+array[j]+array[start]+array[end];
                    //If found then add them to the resultant array
                    if(sum==targetSum){
                    res.add(new Integer[]{array[i],array[j],array[start],array[end]});
                    start++;
                    }
                    //Increment start pointer is sum<targetSum
                    if(sum < targetSum){
                        start++;
                    }
                    //Decrement end pointer if sum > targetSum
                    else{
                        end--;
                    }
                }
            }
        }
        //return the final resultant array
        return res;
      }
}
