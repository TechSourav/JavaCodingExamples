package org.sourav.AlgoExpert.array;

import java.util.Arrays;

public class SmallestDiff {

    public static void main(String[] args) {
        int[] arrayOne = {-1, 5, 10, 20, 28, 3};
        int[] arrayTwo = {26, 134, 135, 15, 17};

        Arrays.sort(arrayOne); // -1,3,5,10,20,28
        Arrays.sort(arrayTwo); // 15,17,26,134,135

        int[] results = new int[] {arrayOne[0], arrayTwo[0]};

        int smallest = Integer.MAX_VALUE;

        int index1 = 0;
        int index2 = 0;

        while (index1 < arrayOne.length && index2 < arrayTwo.length) {
            int first = arrayOne[index1]; // -1
            int sec = arrayTwo[index2]; // 15

            int diff = Math.abs(first - sec); // 16

            if (diff < smallest) { // 16 < 9999999
                smallest = diff; // 16
                results = new int[] {first, sec}; // -1, 15
            }

            if (first < sec) { // -1, 16
                index1++; // 1
            } else {
                index2++;
            }
        }

        System.out.println(Arrays.toString(results));

    }

}
