import java.util.*;

public class three {
    public static void main(String[] args) {
        
    }

    //TC - O(N^2)   SC - O(N)
    //Sort the array and traverse it. For each number in iterattion, do a two pointer approach to find
    //all the pairs when added with our current iteration value, would sum up to the targetSum and add them to 
    //the result.
        public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
            ArrayList<Integer[]> res = new ArrayList<Integer[]>();
            //If Length of array is less than two then we can't have a triplet
            if(array.length<2){
                return res;
            }
            //Sort the array
            Arrays.sort(array);
            //Traverse through the array and for every element initialize start and end pointers as i+1 and arr.length-1
            for(int i=0;i<array.length-2;i++){
                int start = i+1;
                int end = array.length-1;
                //use the two pointer approach to find the pair that when added with arr[i] sums up to the targetSum
                while(start<end){
                    if((array[i]+array[start]+array[end])==targetSum){
                        res.add(new Integer[]{array[i],array[start],array[end]});
                        start++;
                        end--;
                    } else if((array[i]+array[start]+array[end])<targetSum){
                        start++;
                    } else if((array[i]+array[start]+array[end])>targetSum){
                        end--;
                    }
                }
            }
            //return the final result
            return res;
        }
}
