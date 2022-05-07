import java.util.*;

public class spiral {
    public static void main(String[] args) {
        
    }

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        //Get the size of the matrix
        int height = array.size()-1;
        int width = array.get(0).size() - 1;

        //Initialize the pointers that we will use to traverse the array
        int row = 0, col = 0;

        //value of goingDown variable tells us whether we are traversing down or up 
        boolean goingDown = true;

        //Initialize the resultant array
        List<Integer> res = new ArrayList<Integer>();
        
        //We traverse as long as we are within the bounds of the array
        while(!isOutOfBounds(row,col,height,width)){
            //Add the current value to the resultant array
            res.add(array.get(row).get(col));

            //If we are going down then we have to check the edge case of whether we are on the boundary of matrix
            if(goingDown){
                //If we are on the boundary
                if(col == 0 || row == height){
                    //we change the value of goingDown
                    goingDown = false;
                    //If we are on the last row we move our col pointer forward
                    if( row == height){
                        col++;
                    }
                    //If we are on the first column, we move our row pointer to below
                    else{
                        row++;
                    }
                }
                //Else we increase row and decrease col while we are going down to get diagonal element
                else{
                    row++;
                    col--;
                }
            }
            //If we are going up, we do similar step as above, we just change the edge cases
            else{
                //If we are on the top row or last column
                if(row == 0 || col == width){
                    //we change the direction
                    goingDown = true;
                    //If we are on the last column we go down
                    if(col == width){
                        row++;
                    }
                    //If we are on the first row we go forward
                    else{
                        col++;
                    }
                }
                //Else we decrease row and increase to to access diagonal element
                else{
                    row--;
                    col++;
                }
            }
        }
        
        //Return the final resultant array
        return res;
    }
        
    //This function check that whether our current pointers are within the bound of matrix or not
     public static boolean isOutOfBounds(int row, int col, int height, int width){
         return row < 0 || row > height || col < 0 || col > width;
     }
}
