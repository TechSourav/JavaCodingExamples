package org.sourav.Leetcode.SlidingWindow;

public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes(nums, 3));
    }

    public static int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int max = 0;
        int count = 0;
        while (r < nums.length) {
            if (nums[r] == 0 && count < k) {
                max = Math.max(max, r - l + 1);
                r++;
                count++;
            } else if (nums[r] != 0) {
                max = Math.max(max, r - l + 1);
                r++;
            } else if (nums[r] == 0 && count == k) {
                if (nums[l] == 0) {
                    count--;
                }
                l++;
            }
        }
        return max;
    }

}
