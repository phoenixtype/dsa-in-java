import java.util.Scanner;
import java.util.Arrays;

// https://www.hackerrank.com/challenges/arrays-ds/problem

public class ReverseArray {

    public static int[] reverseArray(int[] a) {
        int left = 0;
        int right = a.length - 1;

        // Swap elements from outside in
        while (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;

            left++;
            right--;
        }

        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrCount = scanner.nextInt();
        int[] arr = new int[arrCount];

        for (int i = 0; i < arrCount; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] res = reverseArray(arr);

        // Prints the array in a readable format like [4, 3, 2, 1]
        System.out.println(Arrays.toString(res));

        scanner.close();
    }
}