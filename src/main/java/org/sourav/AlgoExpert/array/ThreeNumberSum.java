package org.sourav.AlgoExpert.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    public static void main(String[] args) {
        int[] arr = {12, 3, 1, 2, -6, 5, -8, 6};
        threeNumberSum(arr, 0);
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        final List<Integer[]> list = new ArrayList<>();
        Arrays.sort(array); // -8,-6,1,2,3,5,6,12

        for (int i = 0; i< array.length-1; i++) {
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                if (array[i] + array[left] + array[right] == targetSum) {
                    list.add(new Integer[]{array[i],array[left], array[right]});
                    right--;
                    left++;
                } else if (array[i] + array[left] + array[right] < targetSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return list;
    }

}
