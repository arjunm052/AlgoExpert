import java.util.*;

class Program {

    static class Pair {
        int val;
        int idx;

        Pair(int value, int index) {
            this.val = value;
            this.idx = index;
        }
    }

    // Function to find the Maximum Area Histogram
    // TC - O(N) SC - O(N)
    public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
        // We find the next smallest left and next smallest right for each element in
        // the array
        int[] nsl = new int[buildings.size()];
        int[] nsr = new int[buildings.size()];

        // initialize the result vairable
        int res = 0;

        // We will use this stack to find NSL and NSR
        Stack<Pair> stack = new Stack<Pair>();

        // First find NSL for each element in the array
        for (int i = 0; i < buildings.size(); i++) {
            // If the stack is empty
            if (stack.isEmpty()) {
                // then no smaller element in present on the left side of the current element
                nsl[i] = -1;
            }
            // If we see a smaller element just on top of stack, then store its index in res
            // nsl array
            else if (stack.size() > 0 && stack.peek().val < buildings.get(i)) {
                nsl[i] = stack.peek().idx;
            }
            // Else if the element on top of stack is greater than current element
            else if (stack.size() > 0 && stack.peek().val >= buildings.get(i)) {
                // Keep popping from the stack until the stack becomes empty or we find a
                // smaller element
                while (stack.size() > 0 && stack.peek().val >= buildings.get(i)) {
                    stack.pop();
                }

                // If the stack becomes empty mark the res[i] as -1 as no smaller element exists
                // on left
                if (stack.isEmpty()) {
                    nsl[i] = -1;
                }
                // else store the index of the element on top of stack
                else {
                    nsl[i] = stack.peek().idx;
                }
            }
            // Add the current element on top of stack
            stack.push(new Pair(buildings.get(i), i));
        }

        // Clear all the elements from the stack
        stack.clear();

        // First find NSL for each element in the array
        for (int i = buildings.size() - 1; i >= 0; i--) {
            // If stack is empty we store the length of the array in res, at this building
            // can be extended to the end of the array as no smaller building exists on
            // right of it
            if (stack.isEmpty()) {
                nsr[i] = buildings.size();
            }
            // If we see a smaller element just on top of stack, then store its index in res
            // nsl array
            else if (stack.size() > 0 && stack.peek().val < buildings.get(i)) {
                nsr[i] = stack.peek().idx;
            }
            // Else if the element on top of stack is greater than current element
            else if (stack.size() > 0 && stack.peek().val >= buildings.get(i)) {
                // Keep popping from the stack until the stack becomes empty or we find a
                // smaller element
                while (stack.size() > 0 && stack.peek().val >= buildings.get(i)) {
                    stack.pop();
                }

                // If the stack becomes empty mark the res[i] as -1 as no smaller element exists
                // on left
                if (stack.isEmpty()) {
                    nsr[i] = buildings.size();
                }
                // else store the index of the element on top of stack
                else {
                    nsr[i] = stack.peek().idx;
                }
            }
            // Add the current element on top of stack
            stack.push(new Pair(buildings.get(i), i));
        }

        // Traverse through the buildings array again and calculate the width to which
        // it can be extended
        for (int i = 0; i < buildings.size(); i++) {
            // Get height of building
            int buildingHeight = buildings.get(i);
            // store the max result in res variable
            // Area will be currentBuildingHeight * width to which it can be extended
            res = Math.max(res, buildingHeight * (nsr[i] - nsl[i] - 1));
        }

        // return the final result
        return res;
    }
}
