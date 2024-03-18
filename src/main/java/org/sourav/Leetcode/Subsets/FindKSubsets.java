package org.sourav.Leetcode.Subsets;

public class FindKSubsets {

    public static void main(String[] args) {
        int[] arr = {1,3,5,21,19,7,2};
        printSubsets(arr, 10, "", 0, 0);
    }

    private static void printSubsets(int[] arr, int target, String set, int sum, int index) {
        if (index == arr.length) {
            if (sum == target) {
                System.out.println(set + ".");
            }
            return;
        }
        printSubsets(arr, target, set + arr[index] + ",", sum + arr[index], index + 1);
        printSubsets(arr, target, set, sum, index + 1);
    }

}
