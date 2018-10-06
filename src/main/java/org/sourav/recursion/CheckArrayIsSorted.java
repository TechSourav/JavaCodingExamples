package org.sourav.recursion;

public class CheckArrayIsSorted {
    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6, 8, 12, 13, 92};
        int[] arr2 = {8, 3, 5, 12, 1231, 1, 9};

        if (isSorted(arr1, arr1.length))
            System.out.println("Arr1 Sorted");
        else {
            System.out.println("Arr1 Not Sorted");
        }
        if (isSorted(arr2, arr2.length))
            System.out.println("Arr2 Sorted");
        else {
            System.out.println("Arr2 Not Sorted");
        }

    }

    private static boolean isSorted(int[] arr, int len) {
        return finalResult(arr, 0, len);
    }

    private static boolean finalResult(int[] arr, int n, int len) {
        if (n == len - 1)
            return true;
        if (arr[n] < arr[n + 1]) {
            return finalResult(arr, ++n, len);
        } else {
            return false;
        }
    }
}
