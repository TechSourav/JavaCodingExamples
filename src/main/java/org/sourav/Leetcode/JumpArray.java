package org.sourav.Leetcode;

public class JumpArray {

    public static void main(String[] args) {
        final int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(jump(arr));
    }

    public static int jump(int[] nums) {
        int jumps = 0, currEnd = 0, currFarthest = 0;

        for (int i = 0; i < nums.length -1 ; i++) {
            currFarthest = Math.max(currFarthest, i + nums[i]);
            if (currFarthest >= nums.length - 1)
                return jumps + 1;
            if (i == currEnd) {
                currEnd = currFarthest;
                jumps++;
            }
        }

        return jumps;
    }
}
