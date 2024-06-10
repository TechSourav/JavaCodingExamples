package org.sourav.Leetcode.matrices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int direction = 1;

        int row = 0;
        int col = -1;

        final List<Integer> ans = new ArrayList<>();

        while (rows > 0 && cols > 0) {
            for (int i = 0; i < cols; i++) {
                col += direction;
                ans.add(matrix[row][col]);
            }
            rows--;

            for (int i = 0; i < rows; i++) {
                row += direction;
                ans.add(matrix[row][col]);
            }
            cols--;

            direction *= -1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][][] inputs = {
            {{1}},
            {{6}, {2}},
            {{2, 14, 8}, {12, 7, 14}},
            {{3, 1, 1}, {15, 12, 13}, {4, 14, 12}, {10, 5, 11}},
            {{10, 1, 14, 11, 14}, {13, 4, 8, 2, 13}, {10, 19, 1, 6, 8}, {20, 10, 8, 2, 12}, {15, 6, 8, 8, 18}}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tMatrix:");
            print2D(inputs[i]);

            System.out.println("\n\tSpiral order: " + spiralOrder(inputs[i]));

            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static void print2D(int[][] mat) {
        // Loop through all rows
        for (int[] row : mat) {
            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
        }
    }


}
