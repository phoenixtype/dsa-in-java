package codility;

// Write a function that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

// Expected Constraints:
// N is an integer within the range [1 ... 100,000].
// Each element of array A is an integer within the range [-1,000,000 ... 1,000,000].

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 5, 4, 1, 2}));
        System.out.println(hashSetSolution(new int[]{1, 3, 5, 4, 1, 2}));
    }

    // A = [1, 3, 6, 4, 1, 2]
    public static int solution(int[] A) {
        int n = A.length;
        boolean[] seen = new boolean[n + 2]; // to include 0 (which we don't care about and n + 1

        for (int v : A) {
            if (v > 0 && v <= n + 1) {
                seen[v] = true;
            }
        }

        for (int i = 1; i <= n + 1; i++) {
            if (!seen[i]) {
                return i;
            }
        }
        return -1;
    }

    // A = [1, 3, 6, 4, 1, 2]
    public static int hashSetSolution(int[] A) {
        Set<Integer> seen = new HashSet<>();

        for (int v : A) {
            if (v > 0) {
                seen.add(v);
            }
        }

        int missing = 1;
        while(seen.contains(missing)) {
            missing++;
        }

        return missing;
    }


}
