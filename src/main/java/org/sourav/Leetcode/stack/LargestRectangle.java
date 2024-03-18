package org.sourav.Leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LargestRectangle {

    public static void main(String[] args) {
        int[] h = {6,7,5,2,4,5,8,3};
        System.out.println(largestRectangleArea(h));
    }


    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        // Pushing "-1" to the stack to mark the end.
        stack.push(-1);
        // Length og the heights array.
        int length = heights.length;

        int maxArea = 0;
        for (int i = 0; i < length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int currentHeight = heights[stack.pop()];
                // right_limit - left_limit - 1
                int currentWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(i);
        }
        // Once we traverse the aray completely, but still stack has valid data, we need to calculate the area and compare.
        while (stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            // right_limit - left_limit - 1. Here the right_limit is the length of the array.
            int currentWidth = length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }
        return maxArea;
    }
}
