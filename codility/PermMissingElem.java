package codility;

// An array A consisting of N different integers is given.
// The array contains integers in the range [1...N+1], which means that exactly one element is missing.
// Write a function that, given an array A, returns the value of the missing element.

public class PermMissingElem {
    public static void main(String[] args) {
        int[] A = {1,2,3,5};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        // expected sum
        long n = A.length;
        long expectedSum = ((n + 1) * (n + 2)) / 2;

        long actualSum = 0;
        //actual sum
        for (int v : A) {
            actualSum += v;
        }

        return (int) (expectedSum - actualSum);
    }
}
