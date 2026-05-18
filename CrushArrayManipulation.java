import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.hackerrank.com/challenges/crush/problem

public class CrushArrayManipulation {

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // PHASE 1: INITIALIZE THE TRACKING ARRAY
        // We use 'long' because adding large 'k' values repeatedly can easily
        // exceed the maximum capacity of a standard 32-bit Integer (2,147,483,647).
        // Size is n + 2 to safely accommodate 1-based indexing and the 'r + 1' lookahead boundary.
        long[] arr = new long[n + 2];

        // PHASE 2: RECORD THE BOUNDARY INSTRUCTIONS ("WAVES")
        // We loop through each query instruction.
        for (List<Integer> query : queries) {
            int l = query.get(0); // The starting index (1-based)
            int r = query.get(1); // The ending index (1-based)
            int k = query.get(2); // The value to add

            arr[l] += k;       // "Start adding K from this index onward"
            arr[r + 1] -= k;   // "Stop adding K after index r (cancel it out at r + 1)"
        }

        // PHASE 3: ACCUMULATE THE RUNNING SUM TO FIND THE HIGHEST PEAK
        long maxValue = 0;   // Tracks the highest value discovered
        long currentSum = 0; // Tracks our running total as we walk left-to-right

        // Walk through the array from index 1 up to n to compute the prefix sums.
        for (int i = 1; i <= n; i++) {
            currentSum += arr[i];
            if (currentSum > maxValue) {
                maxValue = currentSum;
            }
        }

        return maxValue;
    }

    // THE MAIN METHOD (RUNNABLE)
    public static void main(String[] args) throws IOException {
        // Using BufferedReader for fast input handling
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter N (array size) and M (number of queries), followed by the queries:");

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> queries = new ArrayList<>();

        // Read the M queries from the console
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            List<Integer> query = new ArrayList<>();
            query.add(Integer.parseInt(st.nextToken())); // l
            query.add(Integer.parseInt(st.nextToken())); // r
            query.add(Integer.parseInt(st.nextToken())); // k
            queries.add(query);
        }

        // Execute the algorithm
        long result = arrayManipulation(n, queries);

        // Print the final result to the console
        System.out.println("\nMaximum value in the manipulated array: " + result);
        bufferedReader.close();
    }
}