import java.util.*;

public class range {
    public static void main(String[] args) {
        
    }

    //TC - O(N)   SC - O(N)
    //Store all the numbers in the HashMap mapping to a boolean value. These boolean value will tell is
    //whether we can start exploring that number or not. Initially set the boolean value to true.
    //As we keep explopring the numbers mark them false. Main the length of the longest chain.
    public static int[] largestRange(int[] array) {
        //Initialize the resultant Array
		int[] res = new int[2];
        //This will hold the length of the longest range found yet
		int maxLength = Integer.MIN_VALUE;

        //Initialize a HashMap and store all the elements of the array initially mapped to true
        HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
		for(int val : array){
			map.put(val,true);
		}

		//Now start traversing the array
		for(int val: array){
            //If that number is already visited then we continue to next iteration
			if(map.get(val)==false){
				continue;
			}
            //Otherwise Mark that value as visited
			map.put(val,false);
            //Initialize the length to 1
			int length = 1;
            //Also initialize the left and right number that we will start looking in the hashmap
			int leftNum = val-1;
			int rightNum = val+1;
			
            //Keep iterating through the hashmap until we find the left extremity of the range
			while(map.containsKey(leftNum)){
                //Also keep marking the numbers false as to avoid visiting them again
				map.put(leftNum,false);
                //inrcrease the length
				length++;
                //decrease the number
				leftNum--;
			}
			
            //Keep iterating through the hashmap until we find the right extremity of the range
			while(map.containsKey(rightNum)){
                //Mark number as visited
				map.put(rightNum,false);
                //Increase Range
				length++;
                //Increase number
				rightNum++;
			}
			
            //If our current length is greater than the maxLength, then update the maxLength and the result
			if(length>maxLength){
				maxLength = length;
				res[0] = leftNum+1;
				res[1] = rightNum-1;
			}
		}
		
        //return the final result
		return res;
  }
}
