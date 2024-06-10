package org.sourav.Leetcode.matrices;

import java.util.*;

class SetZeroes {

    public static int[][] setMatrixZeros(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        boolean fcol = false;
        boolean frow = false;

        // Check if there is a zero in the first column, set fcol to true.
        for (int i = 0; i < rows; i++) {
            if (mat[i][0] == 0) {
                fcol = true;
                break;
            }
        }

        // Check if there is a zero in the first row, set frow to true.
        for (int i = 0; i < cols; i++) {
            if (mat[0][i] == 0) {
                frow = true;
                break;
            }
        }

        // Check row elements (by ignoring the first row and first column). If zero is found,
        // set the corresponding row's and column's first element to zero.
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (mat[i][j] == 0) {
                    mat[0][j] = 0;
                    mat[i][0] = 0;
                }
            }
        }

        // Check every row's first element starting from the second row.
        // Set the complete row to zero if zero is found.
        for (int i = 1; i < rows; i++) {
            if (mat[i][0] == 0) {
                Arrays.fill(mat[i], 0);
            }
        }

        // Check every column's first element starting from the second column.
        // Set the complete column to zero if zero is found.
        for (int j = 1; j < cols; j++) {
            if (mat[0][j] == 0) {
                for (int i = 1; i < rows; i++) {
                    mat[i][j] = 0;
                }
            }
        }

        // If fcol is true, set the first column to zero.
        if (fcol) {
            for (int i = 0; i < rows; i++) {
                mat[i][0] = 0;
            }
        }

        // If frow is true, set the first row to zero.
        if (frow) {
            Arrays.fill(mat[0], 0);
        }

        return mat;
    }

    // Driver code
    public static void main(String[] args) {
        int[][][] mat = {
            {{1, 1, 0}, {1, 0, 1}, {1, 1, 1}},
            {{1, 1, 1, 1, 1}, {0, 0, 1, 1, 1}, {1, 1, 1, 1, 0}, {1, 1, 1, 1, 1}},
            {{3, 5, 2, 0}, {1, 0, 4, 6}, {7, 3, 2, 4}},
            {{1, 2, 3, 4}, {4, 5, 6, 7}, {8, 9, 4, 6}},
            {{2, 6, 5, 4, 9, 1}, {7, 2, 0, 0, 5, 4}, {1, 1, 1, 1, 0, 1}, {9, 8, 2, 0, 1, 3}, {7, 8, 6, 5, 4, 3}, {9, 8, 1, 2, 5, 6}}
        };

        for (int i = 0; i < mat.length; i++) {
            System.out.println((i + 1) + ". \tOriginal Matrix:");
            print2D(mat[i]);
            System.out.println();
            int[][] result = setMatrixZeros(mat[i]);
            System.out.println("\n\tMatrix with Zeroes:");
            print2D(result);
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