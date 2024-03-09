package org.sourav.Leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 1};
        System.out.println(Arrays.toString(nextSmaller(a)));
    }

    public static int[] nextSmaller(int[] arr) {
        int n = arr.length;
        int[] output = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            int number = arr[i];

            while (!stack.isEmpty() && stack.peek() >= number) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                output[i] = -1;
            } else {
                output[i] = stack.peek();
            }

            stack.push(number);
        }

        return output;
    }
}
