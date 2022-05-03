import java.util.*;

public class longPeak {
    public static void main(String[] args) {
        
    }

    //TC - O(N)  SC - O(1)
    //As we iterate through the array from left to right, whenever we find a peak, expand outward to find the 
    //length of the peak. Given what peak looks like and how many peaks can therefore fit in an array, this
    //process would result in a linear time algorithm. Make sure to keep track of the longest peak. 
    public static int longestPeak(int[] array) {
	//If the length of the array is less than 3, then there will be no peak
	if(array.length<3){
		return 0;
	}

	//Initialize the res variable
    int res = Integer.MIN_VALUE;

	//Traverse the whole array and look for a peek. arr[i] would be a peek if it strictly greater than both its neighbours
	for(int i=1;i<array.length-1;i++){
		if(array[i]>array[i-1] && array[i]>array[i+1]){
			//LengthOfPeak method return the length of the longest peak that can be formed from current peak
			int length = lengthOfPeak(array,i);
			//Update the result variable
    		res = Math.max(length,res);
		}
	}
	//Case when no peak is found
	if(res == Integer.MIN_VALUE){
		return 0;
	}
	//Return the final result
    return res;
  }
	
    //This method finds the Largest Peak
	public static int lengthOfPeak(int[] arr,int peak){
		//Initialize Left and right Pointers from the given peak index
		int left = peak-1, right = peak+1;
		//Move the left peak pointer to the left as long as arr[left] is smaller than arr[left+1]
		while(left>=0 && arr[left]<arr[left+1]){
			left--;
		}
		//Move the right peak pointer to the right as long as arr[right] is smaller than arr[right-1]
		while(right<arr.length && arr[right]<arr[right-1]){
			right++;
		}
		//Calculate the final result and return
		return right-left-1;
	}
}
