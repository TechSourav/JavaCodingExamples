package org.sourav.Leetcode.SlidingWindow;

public class MinSumSubArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(minSubArrayLen2(11, arr));
    }

    // 1. Brute Force approach
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int curr_sum = 0;
        int min_len = Integer.MAX_VALUE;

        for (int start = 0; start < n; start++) {
            curr_sum = nums[start];

            if (curr_sum >= target) {
                return 1;
            }

            for (int end = start + 1; end < n; end++) {
                curr_sum += nums[end];
                if (curr_sum >= target && (end - start + 1) < min_len) {
                    min_len = end - start + 1;
                }
            }
        }
        return min_len;

    }

    // 2. Two pointer approach
    public static int minSubArrayLen2(int target, int[] nums) {
        if(nums == null || nums.length == 0 ) return 0;

        int i = 0, j = 0 , sum = 0 , min = Integer.MAX_VALUE;
        while(j < nums.length){
            sum += nums[j++];
            while(sum >=target){
                min = Math.min(min, j - i); //(old j) - i + 1 = j - i
                sum -= nums[i++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;

        /*if (nums.length == 0) {
            return 0;
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = nums[left];

        for (int right = 1; right < nums.length; right++) {
            sum = sum + nums[right];
            while (sum > target) {
                sum -= nums[left];
                left++;
            }
            if (sum == target) {
                minLen = Math.min(minLen, right - left + 1);
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;*/

    }

}
