package org.sourav.Leetcode.CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicateNumbers {

    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(arr));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return List.of();
        }

        List<Integer> ans = new ArrayList<>();

        int i = 0;

        while (i < n) {
            int corrIdx = nums[i] - 1;
            if (nums[i] != nums[corrIdx]) {
                int t = nums[i];
                nums[i] = nums[corrIdx];
                nums[corrIdx] = t;
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j+1) {
                ans.add(nums[j]);
            }
        }

        return ans;
    }

}
