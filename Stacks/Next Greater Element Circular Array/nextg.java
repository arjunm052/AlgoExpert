public class nextg {
    public static void main(String[] args) {

    }

    // Function to get the next greater element to right of every element in a
    // circular array
    //***** TC - O(N)  SC - O(N) *****
    public int[] nextGreaterElement(int[] array) {
        // Initlaize the resultant array with -1
        int[] res = new int[array.length];
        Arrays.fill(res, -1);

        // Create a stack to hold all the integers
        Stack<Integer> stack = new Stack<>();

        // Traverse the array twice taking i to 2*length and getting index by i%length
        for (int i = 0; i < 2 * array.length; i++) {
            // Get the index of the current element
            int idx = i % array.length;

            // While the stack has elements and the curent element is greater than the top
            // element on stack,
            // mark the currrent element as the NGR element for the index present on top
            while (stack.size() > 0 && array[stack.peek()] < array[idx]) {
                // Get the index present on top of stack
                int top = stack.pop();
                // Set the current element as the NGR element for the fetched index in res array
                res[top] = array[idx];
            }
            // Push the index of current element on top of stack
            stack.push(idx);
        }
        return res;
    }
}
