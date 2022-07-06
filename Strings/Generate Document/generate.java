import java.util.*;

class generate {
    // Function that check whether we can generate a document from a given list of
    // characters
    // TC - O(N) SC - O(1)
    public boolean generateDocument(String characters, String document) {
        // We can always generate a document of empty string
        if (document.equals("")) {
            return true;
        }

        // Initialize a HashMap to store the frequency of given characters
        HashMap<Character, Integer> map = new HashMap<>();

        // Fill the hashmap with the frequency of given characters
        for (char c : characters.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Now go through the given document and if we find a character that doesn't
        // exist in the map then return false
        for (char c : document.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            // else decrement the frequency of that character
            map.put(c, map.get(c) - 1);
        }

        // Now traverse through the hashmap and if we find a character whose frequency
        // is smaller than zero then return false
        for (Map.Entry<Character, Integer> mapElement : map.entrySet()) {
            if (mapElement.getValue() < 0) {
                return false;
            }
        }

        // Else return true
        return true;
    }
}
