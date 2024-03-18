package org.sourav.Leetcode.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Base case. If k equals to the length of the array, return the array.
        if (arr.length == k) {
            return Arrays.stream(arr).boxed().collect(Collectors.toList());
        }
        List<Integer> result = new ArrayList<>();

        // Binary search to find the closest element
        int left = binarySearch(arr, x);

        // Initialize our sliding window's bounds
        left -= 1;
        int right = left + 1;

        // While the window size is less than k
        while (right - left - 1 < k) {
            // Be careful to not go out of bounds
            if (left == -1) {
                right += 1;
                continue;
            }
            /*
             * Expand the window towards the side with the closer number
             * Be careful to not go out of bounds with the pointers
             */
            if (right == arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                left -= 1;
            } else {
                right += 1;
            }
        }

        // Build and return the window
        for (int i = left + 1; i < right; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    private static int binarySearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {

        int[][] inputs = {
            { 1, 2, 3, 4, 5, 6, 7 },
            { 1, 2, 3, 4, 5 },
            { 1, 2, 4, 5, 6 },
            { 1, 2, 3, 4, 5, 10 }
        };
        int[] k = { 4, 4, 2, 3 };
        int[] x = { 3, 3, 10, -5 };
        for (int i = 0; i < k.length; i++) {
            List<Integer> kList = findClosestElements(inputs[i], k[i], x[i]);
            System.out.print(i + 1);
            System.out.println(".\tThe " + k[i] + " closest elements for the number " + x[i] + " in the array " + Arrays.toString(inputs[i]) + " are: ");
            System.out.print("\t[");
            for (int j = 0; j < k[i] - 1; j++) {
                System.out.print(kList.get(j) + ", ");
            }
            System.out.println(kList.get(k[i] - 1) + "]");
            System.out.println("********************************************************************************************************************************************");
        }
    }
}
