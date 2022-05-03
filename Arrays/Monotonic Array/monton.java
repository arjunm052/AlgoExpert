import java.util.*;

public class monton {
    public static void main(String[] args) {
        
    }
    
    //TC - O(N)  SC - O(1)
    //Check if its either Monotonic Increasing or is it Montonic Deccreasing and their their OR operation
    public static boolean isMonotonic(int[] array) {
        //Base case
        if(array.length==1 || array.length==0){
            return true;
        }    
        //Find whether array is monotonically increasing or decreasing or neither
        boolean isInc = incMonotonic(array);
        boolean isDec = decMonotonic(array);
    
        //return the final result
        return isInc | isDec;
      }
        //Function to check whether the array is monotonically increasing
        public static boolean incMonotonic(int[] arr){
            for(int i=1;i<arr.length;i++){
                if(arr[i]<arr[i-1]){
                    return false;
                }
            }
            return true;
        }
        
        //Function to check whether the array is monotonically decreasing
        public static boolean decMonotonic(int[] arr){
            for(int i=1;i<arr.length;i++){
                if(arr[i]>arr[i-1]){
                    return false;
                }
            }
            return true;
        }
}
