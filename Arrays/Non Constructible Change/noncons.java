import java.util.*;

public class noncons {
    public static void main(String[] args) {
        
    }

    //TC - O(N)   SC - O(1)
    public int nonConstructibleChange(int[] coins) {
        //Sort the given input array
		Arrays.sort(coins);
        //coinChange keeps track of the minimum amount that we can make
        int coinChange = 0;
        //We traverse all the coins and if we find a coin that is bigger than coinChange+1, then 
        //the minimum amount we cannot construct is going to be coinChange+1
		for(int value: coins){
			if(value>coinChange+1){
				return coinChange+1;
			}
            //If it is less than coinchange+1 then we just add its value to the coinChange and carry on
			coinChange+=value;
		}
        //Return the final result
        return coinChange+1;
    }
}
