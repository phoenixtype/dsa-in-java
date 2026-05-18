import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// https://www.hackerrank.com/challenges/array-left-rotation

public class LeftRotation {

    // Complete the 'rotateLeft' function below.
    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Your logic: Loop d times, remove the first element, and add it to the end
        for (int i = 0; i < d; i++) {
            int temp = arr.removeFirst(); // Equivalent to pop(0)
            arr.add(temp);            // Equivalent to append(temp)
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n (array size) and d (number of rotations)
        int n = scanner.nextInt();
        int d = scanner.nextInt();

        // Read the array elements
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }

        // Call the function
        List<Integer> result = rotateLeft(d, arr);

        // Print the result as space-separated integers
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i != result.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        scanner.close();
    }
}