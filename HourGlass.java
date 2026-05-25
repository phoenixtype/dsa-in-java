import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

// https://www.hackerrank.com/challenges/2d-array/problem
//
//         -9 -9 -9  1 1 1
//          0 -9  0  4 3 2
//         -9 -9 -9  1 2 3
//          0  0  8  6 6 0
//          0  0  0 -2 0 0
//          0  0  1  2 4 0

class HourGlass {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */
    public static int hourglassSum(List<List<Integer>> arr) {
        // Start with the smallest possible integer value in Java
        int maxSum = Integer.MIN_VALUE;

        // Loop through the 4 possible starting rows
        for (int r = 0; r < 4; r++) {
            // Loop through the 4 possible starting columns
            for (int c = 0; c < 4; c++) {
                
                // Calculate the sum using the List .get() syntax
                int currentSum = 
                    // Top row
                    arr.get(r).get(c) + arr.get(r).get(c + 1) + arr.get(r).get(c + 2) +
                    // Middle row
                    arr.get(r + 1).get(c + 1) +
                    // Bottom row
                    arr.get(r + 2).get(c) + arr.get(r + 2).get(c + 1) + arr.get(r + 2).get(c + 2);

                // Update the maximum sum if the current one is larger
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }

        return maxSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            String[] arrRowTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTemp[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}