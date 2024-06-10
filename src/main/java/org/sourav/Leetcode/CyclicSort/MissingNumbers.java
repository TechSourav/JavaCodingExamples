package org.sourav.Leetcode.CyclicSort;

public class MissingNumbers {

    public static void main(String[] args) {
        int[] a = {0, 1};
        int missing = a.length;
        for (int i = 0; i < a.length; i++) {
            missing = missing ^ i ^ a[i];
        }

        System.out.println(missing);
    }
}
