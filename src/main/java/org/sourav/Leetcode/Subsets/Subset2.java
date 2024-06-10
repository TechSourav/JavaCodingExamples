package org.sourav.Leetcode.Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    static void backtracking(int[] nums, List<List<Integer>> ans, List<Integer> tempList, int index) {
        ans.add(new ArrayList<>(tempList));
        for (int start = index; start < nums.length; start++) {
            if (start != index && nums[start] == nums[start-1]) {
                continue;
            }

            tempList.add(nums[start]);
            backtracking(nums, ans, tempList, start+1);
            tempList.remove(tempList.size()-1);
        }
    }
}
