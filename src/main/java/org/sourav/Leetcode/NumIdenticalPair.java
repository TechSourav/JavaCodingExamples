package org.sourav.Leetcode;

public class NumIdenticalPair {

    public static void main(String[] args) {
        int[] nums = {1000,1,1,1};
        System.out.println(numIdenticalPairs(nums));
    }

    public static int numIdenticalPairs(int[] nums) {
        // 1,1,1,2,3,3
        //Arrays.sort(nums);
        int count = 0;
        /*for (int i = 0; i<nums.length; i++) {
            for (int j = i+1; j<nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

        }*/

        int[] arr = new int[101];
        for (int i : nums) {
            count = count + arr[i]++;
        }


        return count;
    }

}
