package org.sourav.Leetcode.stack;

import java.util.Stack;

public class MaxRectangle {

    public static void main(String[] args) {

        char [][]arr = {
            { '0', '1', '1', '0' },
            { '1', '1', '1', '1' },
            { '0', '1', '1', '1' },
            { '1', '1', '0', '0' },
        };
        System.out.println(maximalRectangle(arr));
    }

    // Get the maximum area in a histogram given its heights
    public static int leetcode84(int[] heights) {
        Stack< Integer > stack = new Stack < > ();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }

        return maxarea;
    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int maxarea = 0;
        int[] dp = new int[matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {

                // update the state of this row's histogram using the last row's histogram
                // by keeping track of the number of consecutive ones

                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            // update maxarea with the maximum area from this row's histogram
            maxarea = Math.max(maxarea, leetcode84(dp));
        }
        return maxarea;
    }

}
