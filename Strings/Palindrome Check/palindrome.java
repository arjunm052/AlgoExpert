import java.util.*;

class Program {
    // Function to check whether a given string is palindrome or not
    // TC - O(Length of String) TC - O(N)
    public static boolean isPalindrome(String str) {
        // Convert the given string into a character array
        char[] ch = str.toCharArray();
        // Initialize start and end pointers
        int i = 0, j = ch.length - 1;
        // We traverse the string while start pointer is less than end pointer
        while (i < j) {
            // Compare the elements at both ends, if they aren't same then the given string
            // is not a palindrome
            if (ch[i] != ch[j]) {
                return false;
            }
            // Close in the window by increasing start pointer and decreasing end pointer
            i++;
            j--;
        }

        // Given string is palindrome is we successfully come out of the above loop so
        // return true
        return true;
    }
}
