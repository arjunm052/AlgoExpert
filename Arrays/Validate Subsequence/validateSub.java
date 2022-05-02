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
        int i = 0;
            int j = 0;
            while(i<array.size() && j<sequence.size()){
                if(array.get(i)==sequence.get(j)){
                    j++;
                }
                i++;
            }
        return (j==sequence.size());
      }


}
