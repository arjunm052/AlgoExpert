import java.util.*;

class Program {

    // Each object in the stack will have a value, currMin and currMax attribute
    static class minMax {
        int val;
        int min;
        int max;

        minMax(int value, int minimum, int maximum) {
            this.val = value;
            this.min = minimum;
            this.max = maximum;
        }
    }

    static class MinMaxStack {

        // Initialize the stack
        ArrayList<minMax> stack = new ArrayList<>();

        // Function to return top element of stack
        public int peek() {
            // If stack is empty then return -1
            if (stack.size() == 0) {
                return -1;
            }

            // Otherwise return the value of the top element of stack
            return stack.get(stack.size() - 1).val;
        }

        // Function to pop an element from stack
        public int pop() {
            // If stack size is zero then return -1
            if (stack.size() == 0) {
                return -1;
            }

            // Otherwise get the top value from stack
            int res = stack.get(stack.size() - 1).val;
            // Then remove the top element from stack
            stack.remove(stack.size() - 1);

            // return the fetched value
            return res;
        }

        // Function to push an element on the stack
        public void push(Integer number) {
            // if stack size is zero then create a new minMax object and push it onto the
            // stack
            if (stack.size() == 0) {
                stack.add(new minMax(number, number, number));
                return;
            }

            // Otherwise get the currMin and currMax from top element of stack
            int currMin = stack.get(stack.size() - 1).min;
            int currMax = stack.get(stack.size() - 1).max;

            // Push the element on top of stack and update the currMin and currmax value
            // depending the the elements value
            if (number < currMin) {
                stack.add(new minMax(number, number, currMax));
            } else if (number > currMax) {
                stack.add(new minMax(number, currMin, number));
            }
            // If value of element to be inserted is between currMin and currmax then we
            // keep the same currMin and currMax
            else {
                stack.add(new minMax(number, currMin, currMax));
            }
        }

        // Function to return Current Minimum Element in stack in O(1) time
        public int getMin() {
            // If stack is empty return -1
            if (stack.size() == 0) {
                return -1;
            }

            // Otherwise return the currMin value on top of stack
            return stack.get(stack.size() - 1).min;
        }

        // Function to return current maximum element in stack in O(1) time
        public int getMax() {
            // if stack is empty return -1
            if (stack.size() == 0) {
                return -1;
            }

            // Otherwise return the currMax from top of stack
            return stack.get(stack.size() - 1).max;
        }
    }
}
