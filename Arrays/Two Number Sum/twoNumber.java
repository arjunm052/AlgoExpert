import java.util.*;

public class twoNumber{
    public static void main(String[] args) {
        
    }

    //TC - O(N)  SC - O(N)
    //Use a HashSet to keep track of all the visited numbers. Calculate target-arr[i] 
    //and check if it exists in hashset. If it exists then we have our pair. 
    public static int[] twoNumberSum(int[] array, int targetSum) {
	//Use HashSet to keep track of all visited numbers
        HashSet<Integer> hs = new HashSet<Integer>();
            int res[] = new int[2];
	    //Traverse through all the elements of the array
            for(int i=0;i<array.length;i++){
		//Check if we have already visited targetSum-array[i]
                if(hs.contains(targetSum-array[i])){
		    //If we have store the result and return it.	
                    res[0]=array[i];
                    res[1]=targetSum-array[i];
                    return res;
                }else{
		    //If we have not visited targetSum-array[i], just store the array[i] in HashSet and move on
                    hs.add(array[i]);
                }
            }
	//return empty array if no pair exists
        return new int[0];
      }

    //TC - O(NLOGN)    SC - O(1)
    //Sort the array and use the two pointer approach to check for pair.
    public static int[] twoNumberSum2(int[] array, int targetSum) {
		Arrays.sort(array);
        int left = 0;
		int right = array.length-1;
		while(left<right){
			if(array[left]+array[right]==targetSum){
				return new int[]{array[left],array[right]};
			}
			else if(array[left]+array[right]<targetSum){
				left++;
			}
			else{
				right--;
			}
			
		}
        return new int[0];
    }
}




