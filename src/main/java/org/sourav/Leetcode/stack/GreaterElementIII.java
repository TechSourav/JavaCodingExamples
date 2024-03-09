package org.sourav.Leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class GreaterElementIII {

    public static void main(String[] args) {
        int[] n2 = {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElements(n2)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        // Initialize the stack and the output array
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[nums.length];
        Arrays.fill(output, -1);

        int n = nums.length;
        // Start from the last element in the circular array
        int i = 2 * (n - 1);

        while (i >= 0) {
            // Calculate the index of the current element in the circular array
            int j = i % n;
            int number = nums[j];
            while (!stack.isEmpty() && stack.peek() <= number) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                output[j] = stack.peek();
            }

            stack.push(number);
            i--;
        }

        return output;
    }
}
