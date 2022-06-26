public class largest {
    public static void main(String[] args) {

    }

    //TC - O(N)  SC - O(1)
    public static int[] findThreeLargestNumbers(int[] array) {
        // Initialize the resultant array
        // res array will be in sorted order
        int[] res = new int[3];
        Arrays.fill(res, Integer.MIN_VALUE);

        // traverse through all the elements in the array
        for (int value : array) {
            // if current element is greater than our largest value then update all the
            // three largest numbers
            if (value >= res[2]) {
                res[0] = res[1];
                res[1] = res[2];
                res[2] = value;
            }
            // If element is greater than our 2nd largest no. but is smaller than first
            // largest, then update the 2nd and 3rd largest
            else if (value >= res[1] && value < res[2]) {
                res[0] = res[1];
                res[1] = value;
            }
            // If element is greater than 3rd largest but smaller than 2nd largest, update
            // our 3rd largest no.
            else if (value >= res[0] && value < res[1]) {
                res[0] = value;
            }
        }

        // return the final result
        return res;
    }
}
