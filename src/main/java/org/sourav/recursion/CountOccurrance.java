package org.sourav.recursion;

public class CountOccurrance {

    public static void main(String[] args) {
        int[] arr1 = { 2, 4, 6, 8, 4 };
        int key1 = 1;
        System.out.println("Occurrences in arr1: " + countOccurrences(arr1, key1));
    }

    private static int countOccurrences(int[] arr, int key) {
        return getFreq(arr, key, 0);
    }

    private static int getFreq(int[] arr, int key, int index) {
        if (index >= arr.length) {
            return 0;
        }

        int count = arr[index] == key ? 1 : 0;

        int totalCount = count + getFreq(arr, key, index + 1);

        return totalCount;
    }

}
