package codility;

// Problem: MaxCounters
// You are given N counters, initially set to 0, and you have two possible operations on them:
// Increase(X): counter X is increased by 1.
// Max Counter: all counters are set to the maximum value of any counter.
//
// A non-empty array A of M integers is given. This array represents consecutive operations:
// If 1 <= A[K] <= N, then operation K is Increase(A[K]).
// If A[K] = N + 1, then operation K is Max Counter.

// Goal
// Calculate the value of every counter after all operations have been applied.

import java.util.Arrays;

public class MaxCounters {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{3, 4, 4, 6, 1, 4, 4})));

    }

    public static int[] solution(int N, int[] A) {
        int[]  counters =  new int[N];
        int currentMax = 0;
        int lastMaxAll = 0;

        // N => [0, 0, 0, 0, 0]
        // A => [3, 4, 4, 6, 1, 4, 4]
        for (int v : A) {
            if (v >= 1 && v <= N) {
                int op = v - 1; // make 0-based index

                if (counters[op] < lastMaxAll) {
                    counters[op] = lastMaxAll;
                }

                counters[op]++;

                if (currentMax < counters[op]) {
                    currentMax = counters[op];
                }
            } else if (v == N + 1) {
                lastMaxAll = currentMax;
            }
        }

        for (int i = 0; i < N; i++) {
            if (counters[i] < lastMaxAll) {
                counters[i] = lastMaxAll;
            }
        }
        return counters;
    }
}
