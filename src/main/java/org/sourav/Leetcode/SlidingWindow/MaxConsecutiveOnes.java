package org.sourav.Leetcode.SlidingWindow;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(maxConsecutiveOnes(nums));
    }

    private static int maxConsecutiveOnes(final int[] nums) {
        /*int max = 0;
        int left = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 1) {
                continue;
            }
            while (nums[r] == 0 && left < r) {
                max = Math.max(max, r - left + 1);
                left++;
            }
        }
        return max;*/

        /*int left = 0;
        int right = 0;
        int maxCount = 0;

        while(right < nums.length){
            if(nums[right] == 0){
                right++;
                left = right;
            }else{
                maxCount = Math.max(maxCount, right-left+1);
                right++;
            }
        }
        return maxCount;*/

        if (nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int count = 0;

        while (right < nums.length) {
            if (nums[right] != 0) {
                count = Math.max(count, right - left + 1);
                right++;
            } else {
                right++;
                left = right;
            }
        }
        return count;
    }

}
