package org.sourav.Leetcode.CyclicSort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindKMissingNumbers {

    public static void main(String[] args) {
        int[] a = {10,9,8,5,3,1,-5,-10,-11,-99};
        System.out.println(findKMissingNum(a, 5));
    }

    private static List<Integer> findKMissingNum(int[] arr, int k) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while (i < n) {
            if (arr[i] > 0 && arr[i] < n && arr[i] != arr[arr[i]-1]) {
                swap(arr,i,arr[i]-1);
            } else {
                i++;
            }
        }

        final Set<Integer> set = new HashSet<>();
        for (int j = 0; j < n && ans.size() < k; j++) {
            if (arr[j] != j+1) {
                if (!set.contains(j+1)) {
                    ans.add(j+1);
                }
                set.add(arr[j]);
            }
        }
        int m = 1;
        while (ans.size() < k) {
            int tba = n + m++;
            if (!set.contains(tba)) {
                ans.add(tba);
            }
        }
        return ans;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
