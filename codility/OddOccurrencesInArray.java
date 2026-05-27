package codility;

import java.util.HashMap;
import java.util.Map;

// Problem: Every element appears in pairs except one. Find the odd one out.
// Trick: XOR is associative and commutative; x ^ x == 0. XORing everything leaves only the unpaired value.

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{9, 6, 9, 3, 8, 8, 4, 7, 4, 7, 3}));
        System.out.println(solution2(new int[]{9, 6, 9, 3, 8, 8, 4, 7, 4, 7, 3}));

    }

    public static int solution(int[] A) {
        int result = 0;
        for (int v : A) {
            result ^= v;
        }
        return result;
    }

    public static int solution2(int[] A) {
        HashMap<Integer, Integer> counts = new HashMap<>();

        for (int v : A) {
            counts.put(v, counts.getOrDefault(v, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
