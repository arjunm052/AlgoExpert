import java.util.*;

class encrypt {
    // Function to shift the letters of the given string by then given key
    // TC - O(N) SC - O(N)
    public static String caesarCypherEncryptor(String str, int key) {
        // Convert the given string into a character array
        char[] ch = str.toCharArray();
        // In case the key is greater than 26, get the real offset that we need to add
        // by modding it with 26
        int realKey = key % 26;

        // Loop through the characters of the array
        for (int i = 0; i < ch.length; i++) {
            // Get the character at that index
            char c = ch[i];
            // Calculate the Code of the new character by adding the realKey with the code
            // of the character at current index
            int code = (int) (ch[i] + realKey);

            // If calculated code is within valid range we update the character in our array
            if (code >= 97 && code <= 122) {
                ch[i] = (char) code;
            }
            // Else we bring it to the valid range by modding it with 122 (ASCII of z) and
            // then adding value of character 'a'
            else {
                ch[i] = (char) ((code % 122) + 'a');
            }
        }

        // Return the final string
        return String.valueOf(ch);
    }
}
