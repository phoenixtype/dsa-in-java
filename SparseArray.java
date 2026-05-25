import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.hackerrank.com/challenges/sparse-arrays/problem

// https://gemini.google.com/share/d7e590bdeb5e

public class SparseArray {

    /**
     * Counts the occurrences of each query string within the input string list.
     * 
     * Time Complexity: O(N + Q)
     * Space Complexity: O(N)
     */
    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        // Step 1: Build the frequency map of the input strings
        Map<String, Integer> stringCount = new HashMap<>();
        for (String s : stringList) {
            stringCount.put(s, stringCount.getOrDefault(s, 0) + 1);
        }
        
        // Step 2: Query the map for each target string
        List<Integer> result = new ArrayList<>();
        for (String q : queries) {
            result.add(stringCount.getOrDefault(q, 0));
        }
        return result;
    }

    public static void main(String[] args) {
        // Sample Input 1
        List<String> stringList = Arrays.asList("aba", "baba", "aba", "xzxb");
        List<String> queries = Arrays.asList("aba", "xzxb", "ab");

        // Execute the function
        List<Integer> res = matchingStrings(stringList, queries);

        // Print the results
        System.out.println("Input Strings: " + stringList);
        System.out.println("Queries to find: " + queries);
        System.out.println("Matches found:   " + res);
        
        // Expected Output: [2, 1, 0]
    }
}