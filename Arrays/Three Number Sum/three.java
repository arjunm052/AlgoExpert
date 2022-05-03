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
            if(array.length<2){
                return res;
            }
            Arrays.sort(array);
            for(int i=0;i<array.length-2;i++){
                int start = i+1;
                int end = array.length-1;
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
            
        return res;
      }
}
