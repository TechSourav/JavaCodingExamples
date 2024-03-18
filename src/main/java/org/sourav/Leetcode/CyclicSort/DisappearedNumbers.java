package org.sourav.Leetcode.CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {

    public static void main(String[] args) {
        int[] n = {1,3,2,2,4,5,5,6};
        System.out.println(findDisappearedNumbers(n));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j+1) {
                list.add(j+1);
            }
        }
        return list;
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
