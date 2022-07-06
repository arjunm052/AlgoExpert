import java.util.*;

class Program {

    // Function that return the index of first non repeating character
    // TC - O(Length of String) SC - O(1)
    public int firstNonRepeatingCharacter(String string) {
        // Hashmap that will store the frequency of characters
        HashMap<Character, Integer> map = new HashMap<>();

        // Traverse through the string and fill up the frequency map
        for (char c : string.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Initialize res variable
        int res = -1;

        // traverse through the string
        for (int i = 0; i < string.length(); i++) {
            // get the character at current index
            char c = string.charAt(i);

            // If the frequency of the current character is 1 then store its index as res
            // and break out of the loop
            if (map.get(c) == 1) {
                res = i;
                break;
            }
        }

        // return the final result
        return res;
    }
}
