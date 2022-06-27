public class sunset {
    public static void main(String[] args) {

    }

    // TC - O(N) SC - O(1)
    // This function return the array of indexes of all the elements that can view
    // the sunset
    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        // Initialie the resultant array
        ArrayList<Integer> res = new ArrayList<Integer>();

        // Initialize the starting index and step depending on the direction we are
        // facing
        // If we are facing west we traverse from left to right otherwise we go from
        // right to left
        int index = direction.equals("WEST") ? 0 : buildings.length - 1;
        int step = direction.equals("WEST") ? 1 : -1;

        // runningMax keeps track of the maximum height of building seen till now
        int runningMax = 0;

        // While we are within the bounds of the array
        while (index >= 0 && index < buildings.length) {

            // If the current building height is more than maxHeight, then we can see the
            // sunset
            if (buildings[index] > runningMax) {
                // add the index of curent building to res arrayx
                res.add(index);
            }

            // Update the value of maxHeight
            runningMax = Math.max(runningMax, buildings[index]);
            // Update the index by step
            index += step;
        }

        // If the direction is EAST, we have traversed from right to left, so for the
        // final answer we would have to reverse the res array
        if (direction.equals("EAST")) {
            Collections.reverse(res);
        }

        // return the final res array
        return res;
    }
}
