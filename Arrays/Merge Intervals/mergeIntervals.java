import java.util.*;

public class mergeIntervals {
    public static void main(String[] args) {
        
    }

    //TC - O(NLogN)    SC - (N)
    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        //Base Case - No interval or single interval
        if(intervals.length<2){
            return intervals;
        }
           
        //Sort the intervals based on their starting
        Arrays.sort(intervals, (arr1,arr2) -> Integer.compare(arr1[0],arr2[0]));
        //Initialize the resultant array
        List<int[]> res = new ArrayList<int[]>();

        //Get the first Interval from the array
        int[] currentInterval = intervals[0];

        //Traverse Rest of the intervals
        for(int i = 1; i<intervals.length; i++){
            //Get Starting indexes of the interval that we are traversing and currentInterval that we have stored
            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];
            
            //If both of these intervals are overlapping then merge these intervals
            if(currentEnd >= nextStart){
                currentInterval[1] = Math.max(currentEnd,nextEnd);
            }
            //Else add the currentInterval to the result array and make the interval that we are traversing as the
            //new currentInterval
            else{
                res.add(currentInterval);
                currentInterval = intervals[i];
            }
        }
        //Add the last currentInterval that we have left in the reusltant array
        res.add(currentInterval);	
        //Return the final resultant array
        return res.toArray(new int[res.size()][]);
    }
}
