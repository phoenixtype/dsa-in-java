package codility;

// Problem: Find the longest sequence of zeros surrounded by ones in the binary representation of N.
//Example: N=1041 → binary 10000010001 → longest gap = 5

public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(solution(1041));
    }

    public static int solution(int N) {
        String binary = Integer.toBinaryString(N)
;
        int currentGap = 0;
        int maxGap = 0;
        boolean foundOne = false;

        // [1 0 0 0 0 0 1 0 0 0 1]
        for  (char c : binary.toCharArray()) {
            if (c == '1') {
                if (foundOne) {
                    maxGap = Math.max(maxGap, currentGap);
                }
                foundOne = true;
                currentGap = 0;
            } else {
                currentGap++;
            }
        }

        return maxGap;
    }
}
