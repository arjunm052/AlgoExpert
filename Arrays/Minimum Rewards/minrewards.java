import java.util.*;
import java.util.stream.*;

public class minrewards {
    public static void main(String[] args) {
        
    }

    //TC - O(N^2)   SC - O(N)
    public static int minRewards(int[] scores) {
        //Initialize the resultant array with 1 
        int[] res = new int[scores.length];
        Arrays.fill(res,1);
        
        //Traver the scores array
        for(int i = 1;i < scores.length; i++){
            //initialize the j variable to traverse the left part of the array
            int j = i-1;
            //If current score if greater than the previous value just set the current reward to previous val + 1
            if(scores[i] > scores[j]){
                res[i] = res[j]+1;
            }
            //Else traverse to the left side of the value and increment all values which are greater
            //than their next element by Math.max(res[j],res[j+1]+1);
            else{
                while(j>=0 && scores[j]>scores[j+1]){
                    res[j] = Math.max(res[j],res[j+1]+1);
                    j--;
                }
            }
        }

        //Return the sum of the final rewads array
        return IntStream.of(res).sum();
      }

      //TC - O(N)   SC - O(N)
      //We just make two traversals now in the array, One from left to right and other from right to left
      //Similar to peak valley approach. In peak valley approach we find the valley and expand from there 
      //until we find a peak. Here we do the same work without starting from the valley.
      public static int minRewardsOptimal(int[] scores) {
            //Initalize the resultant array by 1
            int res[] = new int[scores.length];
            Arrays.fill(res,1);
            
            //Traverse the array from left to right and if the current element is greater than previous,
            //just set it rewards to reward of previous + 1
            for(int i = 1; i < scores.length; i++){
                if(scores[i]>scores[i-1]){
                    res[i] = res[i-1]+1;
                }
            }
            

            //Traverse the array from right to left, if the current element is greater than its next element,
            //set its reward value to Max of its current value or rewards of next element + 1
            for(int i = scores.length-2; i>=0; i--){
                if(scores[i]>scores[i+1]){
                    res[i] = Math.max(res[i],res[i+1]+1);
                }
            }

        //Return the sum of final rewards array
        return IntStream.of(res).sum();
      }
}
