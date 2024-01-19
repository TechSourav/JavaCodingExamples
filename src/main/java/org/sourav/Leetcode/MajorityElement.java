package org.sourav.Leetcode;

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,5,4,4,6};
        majorEle(nums);
    }

    static int majorEle(int[] nums) {
        int count = 0, maxEl = nums[0];

        for (int i = 0; i < nums.length; i++)
        {
            if (count == 0)
            {
                maxEl = nums[i];
                count++;
            }
            else if (maxEl == nums[i])
            {
                count++;
            }
            else
            {
                count--;
            }
        }
        return maxEl;
    }

}
