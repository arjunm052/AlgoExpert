import java.util.*;

public class prod {
    public static void main(String[] args) {
        
    }

    //TC - O(N)  SC - O(N)
    //Create LeftProduct and RightProduct array that contains all the products of elements till i.
    //Then create the result array from it res[i] = left[i-1]*right[i+1];
    public int[] arrayOfProducts(int[] array) {
        int[] res = new int[array.length];
            int[] leftProd = new int[array.length];
            int[] rightProd = new int[array.length];
            
            //LeftProd[i] means all the product of elements till i
            leftProd[0] = array[0];
            for(int i = 1; i<leftProd.length; i++){
                leftProd[i] = array[i]*leftProd[i-1];
            }
            
            rightProd[rightProd.length-1]=array[array.length-1];
            for(int i = rightProd.length-2; i>=0; i--){
                rightProd[i]=array[i]*rightProd[i+1];
            }
            
            res[0] = rightProd[1];
            res[res.length-1] = leftProd[rightProd.length-2];
            
            for(int i=1;i<res.length-1;i++){
                res[i] = leftProd[i-1]*rightProd[i+1];
            }
            return res;
      }
}
