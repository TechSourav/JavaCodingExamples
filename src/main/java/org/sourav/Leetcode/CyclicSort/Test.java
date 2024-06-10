package org.sourav.Leetcode.CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        int[] a = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(a));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;

        // cyclic sort
        for (int i = 0; i < len;) {
            int correctIdx = nums[i] - 1;
            if (nums[correctIdx] != nums[i]) {
                int temp = nums[correctIdx];
                nums[correctIdx] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        // find missing element
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] != i+1) {
                ans.add(i+1);
            }
        }

        return ans;
    }

}
