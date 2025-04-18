import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Think of a HashMap like a messy closet where you throw clothes (items) in randomly. When you need to find something, you know exactly where it is (fast access), but if someone asks you "What order did you put the clothes in?", you'd have no idea. This is why in the original code, we needed to go back to the original string to check characters in order.
 * A LinkedHashMap is like a closet with numbered hangers. When you put clothes in, each item gets the next available numbered hanger (maintaining insertion order). You can still find any piece quickly, but now you can also walk through the closet from hanger #1 to the end and see items in the exact order you put them in.
 * In our code:
 * Original (HashMap): We had to check the string twice because the map couldn't remember order
 * First loop: Count clothes (characters)
 * Second loop: Look at original string again to find first unique item
 * Optimized (LinkedHashMap): We only need to check once because the map remembers order
 * First loop: Count clothes (characters)
 * Second loop: Just walk through our organized closet (map entries) in order
 * Both solutions will find your first non-repeating character, but LinkedHashMap does it more elegantly by remembering the order for us.
 */
public class FirstNonRepeatingChar {

    /**
     * "Write a Java function to find the first non-repeating character in a string. For example, if the input is 'aabbc', the output should be 'c'."
     */

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar("aabbc"));
    }


    public static char firstNonRepeatingChar(String s) {
        Map<Character, Integer> mapper = new HashMap<>();

        for ( char character : s.toCharArray()) {
            mapper.put(character, mapper.getOrDefault(character, 0) + 1); // if you get the value, then add 1 to it, if you're defaulting then value is zero
        }

        for (char character : s.toCharArray()) {
            if (mapper.get(character) == 1) return character;
        }

        return '\0';
    }

    /**
     *  This will maintain the insertion order of characters, allowing us to iterate through them in the order they appear in the string, which means we only need one loop instead of two.
     *  This optimization maintains the time complexity of O(n) but reduces the space complexity by only needing to iterate through unique characters in the second loop instead of all characters in the string again.
     */

    public static char firstNonRepeatingCharLinkedHashMap(String s) {
        Map<Character, Integer> mapper = new LinkedHashMap<>();

        for (char character : s.toCharArray()) {
            mapper.put(character, mapper.getOrDefault(character, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : mapper.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }

        return '\0';
    }
}
