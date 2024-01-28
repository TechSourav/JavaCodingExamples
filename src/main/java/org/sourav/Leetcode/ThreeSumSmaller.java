package org.sourav.Leetcode;

import java.util.Arrays;

public class ThreeSumSmaller {

    public static void main(String[] args) {
        int[] a = {-2,0,1,3};
        System.out.println(threeSumSmaller(a,2));
    }

    public static int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        int len = nums.length;

        for(int i=0; i<len-2; i++) {
            int left = i+1, right = len-1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] < target) {
                    count += right-left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }


}
