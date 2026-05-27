package codility;

// Problem: Write a function that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
// Split array A into two non-empty parts at index P. Minimize |sum(A[0..P-1]) - sum(A[P..N-1])|.
// codility/tape_equilibrium.png

public class TapeEquilibrium {

    public static void main(String[] args) {
        int[] A = {3,1,2,4,3};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        long total = 0;
        for (int v : A) {
            total += v;
        }

        long leftSum = 0;
        long minDiff = Long.MAX_VALUE;

        for (int i = 0; i < A.length - 1; i++) {
            leftSum += A[i];
            long rightSum = total - leftSum;
            long diff = Math.abs(leftSum - rightSum);

            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return (int) minDiff;
    }
}
