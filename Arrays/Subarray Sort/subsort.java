import java.util.*;

public class subsort{
    public static void main(String[] args) {
        
    }

    //TC - O(N)   SC - O(1)
    //First find all the minimum and maximum of unsorted numbers in the array. Find their correct indexes 
    //and return them.

    public static int[] subarraySort(int[] array) {
        //Initalize the variables that are gonna hold the value of min and max unsorted numbers
        int minUnsorted = Integer.MAX_VALUE;
        int maxUnsorted = Integer.MIN_VALUE;
        
        //Loop through the array and if we find an unsorted number we update our minUnsorted and maxUnsorted
        for(int i = 0; i < array.length; i++){
            //ifUnsorted check whether the number is out of order by comparting it with its neighbours
            if(isUnsorted(array,i)){
                minUnsorted = Math.min(minUnsorted,array[i]);
                maxUnsorted = Math.max(maxUnsorted,array[i]);
            }
        }
        
        //If minUnsorted value remain unchanged that means the whole array is sorted as no unsorted number found
        if(minUnsorted==Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }
        
        //Find the correct position of those Unsorted numbers by doing another traversal of the array
        //and comparing them with the array values
        int smallIndex = 0;
        while(minUnsorted>=array[smallIndex]){
            smallIndex++;
        }
        
        int bigIndex = array.length-1;
        while(maxUnsorted<array[bigIndex]){
            bigIndex--;
        }
          
        //return the correct indexes. That would the subarray that we would have to sort to make the whole array sorted
        return new int[]{smallIndex,bigIndex};
    }
        
        //isUnsorted just checks whether the number is in its correct position or not
        public static boolean isUnsorted(int[] array,int i){
            //Base case if we are checking the first number in the array
            if(i==0){
                return array[i]>array[i+1];
            }
            //Base case if we are checking last number in the array
            else if(i==array.length-1){
                return array[i]<array[i-1];
            }
            //Compare with neighbours and return the result
            else{
                return array[i]<array[i-1] || array[i]>array[i+1];
            }
        }
}