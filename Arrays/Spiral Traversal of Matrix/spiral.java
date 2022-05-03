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
		if(array.length==0){
			return new ArrayList<Integer>();
		}
		
    List<Integer> res = new ArrayList<Integer>();
		int startRow = 0, endRow = array.length-1;
		int startCol = 0, endCol = array[0].length-1;
		
		while(startRow <= endRow && startCol <= endCol){
			for(int i = startCol; i<=endCol; i++){
				res.add(array[startRow][i]);
			}
			
			for(int i = startRow+1; i<=endRow; i++){
				res.add(array[i][endCol]);
			}
			
			for(int i = endCol-1; i>=startCol; i--){
				if(startRow == endRow) break;
				res.add(array[endRow][i]);
			}
			
			for(int i = endRow-1; i>startRow; i--){
				if(startCol == endCol) break;
				res.add(array[i][startCol]);
			}
			
			startRow+=1;
			endRow-=1;
			startCol+=1;
			endCol-=1;
			
		}
    return res;
  }
}
