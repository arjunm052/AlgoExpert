import java.util.*;

public class dup{
    public static void main(String[] args) {
        
    }
    
    //TC - O(N)   SC - O(1)
    //Since the value of the elements lies in the range of 1 to N inclusive where N is the size of the array
    //we can use the values in the array as indexes. Traverse through the array and fetch the current value.
    //Check whether at that index-1 , the value is negative or not. If it is not negative it means that
    //that number has not yet been visited, mark it negative and move on. If it is negative then it already
    //has been visited, return that number. 
    public int firstDuplicateValue(int[] array) {
        //Traverse through the array
        for(int i = 0;i < array.length; i++){
            //Fetch the absolute value of current element
            int val = Math.abs(array[i]);
            //Check if value at that index is negative or not
            if(array[val-1]<0){
                //If it is negative return that value as it has already been visited and is the first repeating
                return val;
            }
            else{
                //else make it negative and move on
                array[val-1] = array[val-1]*(-1);
            }
        }
        //return -1 if no duplicates found
        return -1;
      }    
}