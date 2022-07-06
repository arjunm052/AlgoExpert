import java.util.*;

class Program {
    // Function that takes in a non empty string and returns its run length encoding
    // TC - O(Length of String) SC - (N)
    public String runLengthEncoding(String string) {
        // Initialize a stringbuilder that will hold our final result
        StringBuilder res = new StringBuilder();

        // count will hold the freqeuency of the current character
        int count = 0;
        // Initially set the curr char to first character of the string
        char currChar = string.charAt(0);

        // Start traversing the given string
        for (char c : string.toCharArray()) {
            // if we have reached a new character or if the character count off currChar has
            // become 9 then add the count and currchar to the result and update the count
            // and new current character
            if (count == 9 || currChar != c) {
                res.append(count);
                res.append(currChar);
                currChar = c;
                count = 0;
            }
            // Increment the count
            count++;
        }

        // After traversing the string, to add the last character that we saw, we append
        // the count and currChar to the res
        if (count != 0) {
            res.append(count);
            res.append(currChar);
        }

        // Convert the stringbuilder to string and return
        return res.toString();
    }
}
