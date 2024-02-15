package org.sourav.Leetcode.SlidingWindow;

public class MaxConsecutiveOnesFlip {

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(nums, 0));
    }

    public static int longestOnes(int[] nums, int k) {
        /*int max = 0;
        int flips = k;
        int left = 0, right = 0;

        while (right < nums.length) {
            if (nums[right] == 0 && flips == 0) {
                //right++;
                left = right;
                flips = k;
            } else if (nums[right] == 0 && flips > 0) {
                max = Math.max(max, right - left + 1);
                right++;
                flips--;
            } else {
                max = Math.max(max, right - left + 1);
                right++;
            }
        }
        return max;*/

        int left = 0;
        int zeros = 0;
        int maxCount = 0;

        for(int right=0; right<nums.length; right++){
            if(nums[right] == 0){
                zeros++;
            }

            while(zeros > k){
                if(nums[left] == 0){
                    zeros--;
                }
                left++;
            }

            maxCount = Math.max(maxCount, right-left+1);
        }
        return maxCount;
    }

}
