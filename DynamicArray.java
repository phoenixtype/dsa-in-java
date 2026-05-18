import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/dynamic-array/problem

class DynamicArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the first line: n (number of empty arrays) and q (number of queries)
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        // Initialize the 2D list to store the queries
        List<List<Integer>> queries = new ArrayList<>();

        // Loop q times to read all the queries
        for (int i = 0; i < q; i++) {
            List<Integer> query = new ArrayList<>();
            query.add(scanner.nextInt()); // qType
            query.add(scanner.nextInt()); // x
            query.add(scanner.nextInt()); // y
            queries.add(query);
        }

        // Call the dynamicArray function
        List<Integer> result = dynamicArray(n, queries);

        // Print the results, each on a new line
        for (Integer integer : result) {
            System.out.println(integer);
        }

        scanner.close();
    }

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // 1. Declare a 2-dimensional array, arr, with n empty arrays
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        // 2. Declare an integer, lastAnswer, and initialize it to 0
        int lastAnswer = 0;

        // List to store the results of type 2 queries
        List<Integer> answers = new ArrayList<>();

        // 3. Process each query
        for (List<Integer> query : queries) {
            int qType = query.get(0);
            int x = query.get(1);
            int y = query.get(2);

            // Calculate the index using bitwise XOR (^) and modulo (%)
            int idx = (x ^ lastAnswer) % n;

            if (qType == 1) {
                // Append the integer y to arr[idx]
                arr.get(idx).add(y);

            } else if (qType == 2) {
                // Find the value at the specific position and update lastAnswer
                int size = arr.get(idx).size();
                lastAnswer = arr.get(idx).get(y % size);

                // Store the new value of lastAnswer in the answers array
                answers.add(lastAnswer);
            }
        }
        return answers;
    }
}