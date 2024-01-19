package org.sourav.AlgoExpert.array;

import java.util.Arrays;

public class TwoNumberSum {

    public static void main(String[] args) {
        final int[] arr = {3, 5, -4, 8, 11, 1, -1, 6};
        int[] res = twoNumberSum(arr, 10);
        System.out.println("Res :" + res[0] + " , " + res[1]);
    }

    public static int[] twoNumberSum(int[] array, int target) {
        Arrays.sort(array);

        final int len = array.length;
        int left = 0;
        int right = len - 1;

        int [] res = new int[2];
        while (left < right) {
            if (array[left] + array[right] == target) {
                return new int[]{array[left], array[right]};
            }
            if (array[left] + array[right] < target) {
                left++;
            }
            if (array[left] + array[right] > target) {
                right--;
            }
        }

        return new int[]{};
    }
}
