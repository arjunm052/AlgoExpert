public class balanced {
    public static void main(String[] args) {

    }

    // TC - O(N) SC - O(1)
    public static boolean balancedBrackets(String str) {
        // Initialize the stack
        Stack<Character> stack = new Stack<>();

        // Traverse through all the characters in the string
        for (char c : str.toCharArray()) {
            // If the character is an opening bracket push it onto the stack and continue
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            // If it is a closing bracket then first check if the stack is empty, if it is
            // then return false,
            // else pop an element from stack and if it is not opening bracket of the same
            // type of current element then return false
            if (c == ')') {
                if (stack.isEmpty())
                    return false;
                char poppedChar = stack.pop();
                if (poppedChar != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty())
                    return false;
                char poppedChar = stack.pop();
                if (poppedChar != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.isEmpty())
                    return false;
                char poppedChar = stack.pop();
                if (poppedChar != '{') {
                    return false;
                }
            }
        }
        // Return true if the stack is empty after the complete traversal of the string
        return stack.isEmpty();
    }
}
