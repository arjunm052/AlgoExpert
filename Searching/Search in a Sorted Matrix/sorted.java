public class sorted {
    public static void main(String[] args) {

    }

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        // We will start traversing the matrix from the top right corner
        // Initlize the i and j pointers to point at top right corner
        int i = 0;
        int j = matrix[0].length - 1;

        // While we are within the bounds of the matrix we will keep traversing until we
        // find the target
        while (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
            // If our current element is the target, then just return its index
            if (matrix[i][j] == target) {
                return new int[] { i, j };
            }
            // If the target is greater than our current element, then it can't be present
            // in the current row since matrix is row sorted, so move to the next row
            else if (target > matrix[i][j]) {
                i++;
            }
            // If the target is smaller than our curent element, it can't be present in the
            // current column as the matrix is column sorted, so move the the left rowx
            else {
                j--;
            }
        }

        // return {-1,-1} if target is not found
        return new int[] { -1, -1 };
    }
}
