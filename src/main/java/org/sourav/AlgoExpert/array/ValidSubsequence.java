package org.sourav.AlgoExpert.array;

import java.util.Arrays;
import java.util.List;

public class ValidSubsequence {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> seq = Arrays.asList(1, 6, -1, 10);
        System.out.println(isValidSubsequence(arr, seq));
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int j = 0;
        boolean b = false;
        for (int i : sequence) {
            if (j >= array.size()) {
                b = false;
                break;
            }
            for (; j < array.size();) {
                if (array.get(j) == i) {
                    b = true;
                    j++;
                    break;
                } else {
                    b = false;
                    j++;
                }
            }

        }

        return b;
    }

}
