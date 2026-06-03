package codility;

import java.util.Arrays;

public class GenomicRangeQuery {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6})));
        System.out.println(Arrays.toString(bruteForceSolution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6})));
    }

    public static int[] solution(String S, int[] P, int[] Q) {
        int n = S.length();
        int[][] prefix = new int[4][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                prefix[j][i + 1] = prefix[j][i];
            }

            switch (S.charAt(i)) {
                case 'A': prefix[0][i + 1]++; break;
                case 'C': prefix[1][i + 1]++; break;
                case 'G': prefix[2][i + 1]++; break;
                case 'T': prefix[3][i + 1]++; break;
            }
        }

        int m = P.length;
        int[] results = new int[m];
        for (int i = 0; i < m; i++) {
            int hi = Q[i];
            int lo = P[i];

            for (int j = 0; j < 4; j++) {
                if (prefix[j][hi + 1] - prefix[j][lo] > 0) {
                    results[i] = j + 1;
                    break;
                }
            }
        }
        return results;
    }

    // [C, A, G, C, C, T]
    public static int[] bruteForceSolution(String S, int[] P, int[] Q) {
        int[] intArray = new int[S.length()];
        int[] finalArray = new int[P.length];

        for (int i = 0; i < intArray.length; i++) {
            switch (S.charAt(i)) {
                case 'A': intArray[i] = 1; break;
                case 'C': intArray[i] = 2; break;
                case 'G': intArray[i] = 3; break;
                case 'T': intArray[i] = 4; break;
            }
        }
        // P = [2, 5, 0]
        // Q = [4, 5, 6]
        // intArray = [2, 1, 3, 2, 2, 4, 1]
        for (int i = 0; i < P.length; i++) {
            int currentP = P[i]; //0
            int currentQ = Q[i]; //6

            int currentMin = Integer.MAX_VALUE;
            int min = 0;

            for (int j = currentP; j <= currentQ; j++) {
                min = Math.min(intArray[j], currentMin);
                currentMin = min;
            }

            finalArray[i] = min;
        }
        return finalArray;
    }
}
