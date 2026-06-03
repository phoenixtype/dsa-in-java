package codility;

// The Problem Statement: PassingCars
// A non-empty array A consisting of $N$ integers is given. The consecutive elements of array $A$ represent consecutive cars on a road.
// Array $A$ contains only 0s and/or 1s:0 represents a car traveling east.1 represents a car traveling west.
// The goal is to count passing cars.
// We say that a pair of cars $(P, Q)$, where $0 \le P < Q < N$, is passing when $P$ is a car traveling to the east and $Q$ is a car traveling to the west.
// Goal
// Write a function that, given a non-empty array $A$ of $N$ integers, returns the number of pairs of passing cars.
// The function should return -1 if the number of pairs of passing cars exceeds 1,000,000,000.

public class PassingCars {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 1, 0, 1, 1}));

    }

    public static int solution(int[] A) {
        long count = 0;
        long zerosSoFar = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                zerosSoFar++;
            } else {
                count += zerosSoFar;
                if (count > 1_000_000_000L) {
                    return -1;
                }

            }

        }
        return (int) count;
    }

}
