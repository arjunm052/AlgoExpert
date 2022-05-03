import java.util.*;

public class prod {
    public static void main(String[] args) {
        
    }

    //TC - O(N)  SC - O(N)
    //Create LeftProduct and RightProduct array that contains all the products of elements till i.
    //Then create the result array from it res[i] = left[i-1]*right[i+1];
    public int[] arrayOfProducts(int[] array) {
        //Initialize the resultant array
        int[] res = new int[array.length];
        //Initialize the left/rightProd array. leftProd[i] will store the product of all the element on the left side 
        //of arr[i] inclusive and rightProd will store product of all the elements on right of arr[i] inclusive
        int[] leftProd = new int[array.length];
        int[] rightProd = new int[array.length];
            
        //LeftProd[i] means all the product of elements till i including leftProd[i]
        leftProd[0] = array[0];
        //Fill up the leftProd array by finding the Products
        for(int i = 1; i<leftProd.length; i++){
            leftProd[i] = array[i]*leftProd[i-1];
        }
         
        //Fill up the rightProd array by finding the product of elements from right
        rightProd[rightProd.length-1]=array[array.length-1];
        for(int i = rightProd.length-2; i>=0; i--){
            rightProd[i]=array[i]*rightProd[i+1];
        }
        
        //Fill the corners of the resultant array manually 
        res[0] = rightProd[1];
        res[res.length-1] = leftProd[rightProd.length-2];
        //Compute and store rest of the results in the resultant aray
        for(int i=1;i<res.length-1;i++){
            res[i] = leftProd[i-1]*rightProd[i+1];
        }
        //return the final resultant array
        return res;
      }
}
