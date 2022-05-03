import java.util.*;

public class validateSub {
    public static void main(String[] args) {
        
    }

    //TC - O(N)   SC - O(1)
    //Iterate through the main array and look for the first integer in potential subsequence.
    //If you find that Integer, keep on iterating through the main array, but now look for the second
    //integer in the potential subsequence. Continue this process until you find either every integer
    //in subsequence or you reach the end of the main array.
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        //i points to the start of main array
        int i = 0;
        //j points to the start of potential subsequence
        int j = 0;
        
        //Traverse the main array and look for the first character of potential subsequence
        while(i<array.size() && j<sequence.size()){
            //If we find the matching character then just increase the subsequence pointer and look for next character
            if(array.get(i)==sequence.get(j)){
                j++;
            }
            //Also keep increasing the main pointer array
            i++;
        }
        //If j is equal to subsequence length then we have a valid subsequence
        return (j==sequence.size());
      }


}
