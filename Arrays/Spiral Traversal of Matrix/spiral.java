import java.util.*;

public class spiral {
    public static void main(String[] args) {
        
    }


    //TC - O(N)  SC - O(N)
    //Declare fourvariables, a starting row, ending row, starting col and ending column. These four 
    //variables represent the bounds of the irst rectange perimeter in the spiral that we have to 
    //traverse. Traverse the perimeter using these bounds, and then move the bounds inwards.
    //We should end our algorithm once the starting row passes ending row and starting column passes
    //ending column. Also cover the edge case where last traversal is of a 1d array. 
    public static List<Integer> spiralTraverse(int[][] array) {
		//Base Case
		if(array.length==0){
			return new ArrayList<Integer>();
		}
		
		//Initlaie the result array
     	List<Integer> res = new ArrayList<Integer>();

		//These four variables maintain the boundary of the array. We print the perimeter of the current array 
		//and then squeeze in these bounds towards inside to get the perimeter of new smaller array
 		int startRow = 0, endRow = array.length-1;
 		int startCol = 0, endCol = array[0].length-1;
		
		while(startRow <= endRow && startCol <= endCol){
			//Print the top row 
			for(int i = startCol; i<=endCol; i++){
				res.add(array[startRow][i]);
			}
			
			//Print the rightmost column
			for(int i = startRow+1; i<=endRow; i++){
				res.add(array[i][endCol]);
			}
			
			//Print the bottom most row
			for(int i = endCol-1; i>=startCol; i--){
				//Edge Case - When we only have a 1d row in the end to print
				if(startRow == endRow) break;
				res.add(array[endRow][i]);
			}
			
			//Print the leftmost column 
			for(int i = endRow-1; i>startRow; i--){
				//Edge Case - When we only have 1d column left at the end to print
				if(startCol == endCol) break;
				res.add(array[i][startCol]);
			}
			
			//Squeeze in the perimeter bounds to get new smaller array
			startRow+=1;
			endRow-=1;
			startCol+=1;
			endCol-=1;
			
		}
		//Return the Final result array
    	return res;
  	}
}
