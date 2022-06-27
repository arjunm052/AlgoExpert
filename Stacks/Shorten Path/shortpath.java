import java.util.*;

public class shortpath {
    public static void main(String[] args) {

    }

    // Function to shorten the unix path
    // TC - O(N) SC - O(N)
    public static String shortenPath(String path) {
        // Split the given path by using / as delimiter
        String[] tokens = path.split("/");
        // Check whether the path is absolute or relative
        boolean isAbsolutePath = path.charAt(0) == '/';

        // In filter token we remove all the unnecessary tokens like "" and "."
        ArrayList<String> filteredTokens = new ArrayList<String>();
        for (String token : tokens) {
            if (token.length() > 0 && !token.equals(".")) {
                filteredTokens.add(token);
            }
        }

        // Initialize the stack which we will use
        ArrayList<String> stack = new ArrayList<>();

        // If the path is absolute then add "" on top of stack
        if (isAbsolutePath) {
            stack.add("");
        }

        // Now traverse through the filteredtokens list
        for (String token : filteredTokens) {
            // Get the size of the stack
            int size = stack.size() - 1;

            // If the token is equal to ".."
            if (token.equals("..")) {
                // Check whether the stack is empty (meaning given path is a relative path) or
                // whether there
                // already is a ".." present on top of stack
                if (stack.size() == 0 || stack.get(size).equals("..")) {
                    // If true then add this token on top of stack
                    stack.add(token);
                }
                // If this is not an absolute path we will remove the element on top of stack
                else if (!stack.get(size).equals("")) {
                    stack.remove(size);
                }
            }
            // Else just add the token on top of stack
            else {
                stack.add(token);
            }
        }

        // If we are given the root directory as path just return "/"
        if (stack.size() > 0 && stack.get(stack.size() - 1).equals(""))
            return "/";
        // otherwise join the string and return the complete path
        return String.join("/", stack);
    }
}
