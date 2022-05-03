import java.util.*;

public class monton {
    public static void main(String[] args) {
        
    }
    
    //TC - O(N)  SC - O(1)
    //Check if its either Monotonic Increasing or is it Montonic Deccreasing and their their OR operation
    public static boolean isMonotonic(int[] array) {
        if(array.length==1 || array.length==0){
                return true;
        }
            
            boolean isInc = incMonotonic(array);
            boolean isDec = decMonotonic(array);
            
        return isInc | isDec;
      }
        
        public static boolean incMonotonic(int[] arr){
            for(int i=1;i<arr.length;i++){
                if(arr[i]<arr[i-1]){
                    return false;
                }
            }
            return true;
        }
        
        public static boolean decMonotonic(int[] arr){
            for(int i=1;i<arr.length;i++){
                if(arr[i]>arr[i-1]){
                    return false;
                }
            }
            return true;
        }
}
