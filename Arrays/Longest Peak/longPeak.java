import java.util.*;

public class longPeak {
    public static void main(String[] args) {
        
    }

    //TC - O(N)  SC - O(1)
    //As we iterate through the array from left to right, whenever we find a peak, expand outward to find the 
    //length of the peak. Given what peak looks like and how many peaks can therefore fit in an array, this
    //process would result in a linear time algorithm. Make sure to keep track of the longest peak. 
    public static int longestPeak(int[] array) {
	if(array.length<3){
		return 0;
	}
    int res = Integer.MIN_VALUE;
	for(int i=1;i<array.length-1;i++){
		if(array[i]>array[i-1] && array[i]>array[i+1]){
			int length = lengthOfPeak(array,i);
    		res = Math.max(length,res);
		}
	}
	if(res == Integer.MIN_VALUE){
		return 0;
	}
    return res;
  }
	
	public static int lengthOfPeak(int[] arr,int peak){
		int left = peak-1, right = peak+1;
		while(left>=0 && arr[left]<arr[left+1]){
			left--;
		}
		
		while(right<arr.length && arr[right]<arr[right-1]){
			right++;
		}
		
		return right-left-1;
	}
}
