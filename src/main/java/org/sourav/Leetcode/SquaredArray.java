package org.sourav.Leetcode;

public class SquaredArray {

    public static void main(String[] args) {
        int[] nums = {-7,-3,2,3,11};
        sortedSquares(nums);
    }
    public static int[] sortedSquares(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] ans = new int[nums.length];
        int hightIndex = ans.length - 1;

        while (left <= right) {
            int sqLeft = nums[left] * nums[left];
            int sqRight = nums[right] * nums[right];
            if (sqLeft > sqRight) {
                ans[hightIndex] = sqLeft;
                left++;
            } else {
                ans[hightIndex] = sqRight;
                right--;
            }
            hightIndex--;
        }

        return ans;
    }

}
