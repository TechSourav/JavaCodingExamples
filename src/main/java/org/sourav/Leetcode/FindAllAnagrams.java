package org.sourav.Leetcode;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {

    public static void main(String[] args) {
        findAnagrams("cbaebabacd", "abc");
    }
    public static List<Integer> findAnagrams(String s, String p) {
        // base case
        if (s.length() < p.length()) {
            return List.of();
        }

        int pLen = p.length();
        final List<Integer> ans = new ArrayList<>();
        int[] arr = new int[26];
        int[] arr2 = new int[26];

        // verify and store first pLen characters
        for (int i = 0; i < pLen ; i++) {
            // arr will have the ASCII values  till pLen.
            arr[s.charAt(i) - 'a']++;
            arr2[p.charAt(i) - 'a']++;
        }

        getUpdatedAns(ans, arr, arr2, p, 0);

        for (int j = 0; j < s.length() - pLen; j++) {
            // remove first character from the array.
            arr[s.charAt(j) - 'a']--;
            arr[s.charAt(j + pLen) - 'a']++;

            getUpdatedAns(ans, arr, arr2,  p, j+1);
        }

        return ans;

    }

    private static void getUpdatedAns(final List<Integer> ans, final int[] arr, final int[] arr2, final String p, int i) {
        if (Arrays.equals(arr, arr2)) {
            ans.add(i);
        }
    }

}
