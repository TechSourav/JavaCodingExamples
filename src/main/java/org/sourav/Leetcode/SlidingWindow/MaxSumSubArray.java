package org.sourav.Leetcode.SlidingWindow;

public class MaxSumSubArray {

    public static void main(String[] args) {
        int[] nums = {2,1,5,1,3,2};
        System.out.println(maximumSumSubarray2(3, nums));
    }

    // Approach 1: O(n^2)
    static int maximumSumSubarray(int k, int[] nums){
        int max = 0;
         for (int i = 0; i <= nums.length - k; i++) {
             int sum = 0;
             for (int j = i; j < i + k; j++) {
                sum += nums[j];
             }
             max = Math.max(max, sum);
         }

        return max;
    }

    // Approach 2: O(n)
    static int maximumSumSubarray2(int k, int[] nums){
        int max = 0;
        int window = 0;

        for (int j = 0; j < k; j++) {
            window += nums[j];
        }
        max = window;

        for (int i = 0; i < nums.length - k; i++) {
            window = window - nums[i] + nums[i+k];
            max = Math.max(max, window);
        }

        return max;
    }

}
