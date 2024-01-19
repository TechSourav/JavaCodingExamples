package org.sourav.Leetcode;

import java.util.Arrays;

public class ProductSelf {

    public static void main(String[] args) {
        System.out.println(productExceptSelf(new int[] {1,2,3,4}));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr, 1);

        /*for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    arr[i] = arr[i] * nums[j];
                }
            }
        }*/

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        right[right.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }
        /*for (int j = nums.length - 2; j >= 0; j--) {
            right[j] = right[j+1] * nums[j+1];
        }*/

        /*for (int k = 0; k < nums.length; k++) {
            arr[k] = left[k] * right[k];
        }*/

        int mul = 1;

        for (int j = nums.length - 2; j >= 0; j--) {
            mul = mul * nums[j+1];
            left[j] = left[j] * mul;
        }

        return arr;

    }

}
