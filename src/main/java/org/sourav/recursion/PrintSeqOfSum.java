package org.sourav.recursion;

import java.util.Arrays;

/**
 * Input: x = 3
 * Output: 1 1 1
 * 2 1
 * 3
 * <p>
 * Input: x = 4
 * Output: 1 1 1 1
 * 2 1 1
 * 2 2
 * 3 1
 * 4
 **/

public class PrintSeqOfSum {
    public static void main(String[] args) {
        int x = 4;
        String[] arr = new String[x];
        PrintSeqOfSum psos = new PrintSeqOfSum();
        Arrays.fill(arr,"1");
        psos.printSeqNum(arr, x);
    }

    private void printSeqNum(String[] arr, int x) {
        if (x == 0) {
            return;
        } else {
            printArray(arr);
            arr[0] = String.valueOf(Integer.parseInt(arr[x - 1]) + Integer.parseInt(arr[0]));
            arr[x - 1] = " ";
            printSeqNum(arr, --x);
        }
    }

    private void printArray(String[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] != " " ? arr[i] : " " + "  ");
        }
    }
}
