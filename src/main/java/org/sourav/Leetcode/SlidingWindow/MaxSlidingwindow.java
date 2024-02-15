package org.sourav.Leetcode.SlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class MaxSlidingwindow {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,2,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int w) {
        if (nums.length == 0) {
            return new int[0];
        }
        if (w > nums.length) {
            w = nums.length;
        }
        int [] output = new int[nums.length - w + 1];
        Deque<Integer> currentWindow = new ArrayDeque<>();
        for (int i = 0; i < w; i++) {
            currentWindow = cleanUp(i, currentWindow, nums);
            currentWindow.add(i);
        }
        output[0] = nums[currentWindow.getFirst()];
        for (int i = w; i < nums.length; i++) {
            cleanUp(i, currentWindow, nums);
            if (!currentWindow.isEmpty() && currentWindow.getFirst() <= (i - w)) {
                currentWindow.removeFirst();
            }
            currentWindow.add(i);
            output[i - w + 1] = nums[currentWindow.getFirst()];
        }
        return output;
    }

    public static Deque<Integer> cleanUp(int i,
            Deque<Integer> currentWindow,
            int[] nums) {
        while (currentWindow.size() != 0 && nums[i] >= nums[currentWindow.getLast()]) {
            currentWindow.removeLast();
        }
        return currentWindow;
    }
}
