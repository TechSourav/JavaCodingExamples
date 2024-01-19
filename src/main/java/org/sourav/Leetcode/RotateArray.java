package org.sourav.Leetcode;

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        rotateArray(arr, 3);
        System.out.println("Done");
    }

    static void rotateArray(int[] arr, int k) {
        if (k == 0)
            return;
        k = k % arr.length;
        if (k < 0)
            k += arr.length;

        reverse(arr, 0, arr.length - k - 1);
        reverse(arr, arr.length - k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    static void reverse(int[] nums, int i , int j) {
        int li = i;
        int ri = j;

        while (li < ri) {
            int tmp = nums[li];
            nums[li] = nums[ri];
            nums[ri] = tmp;

            li++;
            ri--;
        }
    }

}
