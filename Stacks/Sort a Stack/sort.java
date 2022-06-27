public class sort {
    public static void main(String[] args) {

    }

    // Main function to call for sorting a stack
    // TC - O(N^2)  SC - O(N)
    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        // If stack has only one element then it is already sorted
        if (stack.size() <= 1) {
            return stack;
        }
        // else sort the stack and return it
        return stackSort(stack, stack.size());
    }

    public static ArrayList<Integer> stackSort(ArrayList<Integer> stack, int size) {
        // If stack has only one element then it is already sorted
        if (size <= 1) {
            return stack;
        }

        // Get the top element from the stack and pop it
        int top = stack.get(size - 1);
        stack.remove(size - 1);

        // Sort the rest of the stack
        stackSort(stack, size - 1);

        // Now insert the popped element in the sorted stack in its correct place
        sortedInsert(stack, top);

        // return the sorted stack
        return stack;

    }

    public static void sortedInsert(ArrayList<Integer> stack, int element) {
        // If the stack isempty just add the element and return the stack
        if (stack.size() == 0) {
            stack.add(element);
            return;
        }

        // Get the size of the stack
        int size = stack.size();

        // If the stack is not empty and the element is greater than the element on top
        // of stack, just add the element on top of the stack
        if (stack.size() != 0 && stack.get(size - 1) < element) {
            stack.add(element);
        }

        // else we pop the top element of the stack, recursively call the same
        // sortedInsert function again and then add back the poped element to the stack
        else {
            int top = stack.get(size - 1);
            stack.remove(size - 1);
            sortedInsert(stack, element);
            stack.add(top);
        }
    }
}
