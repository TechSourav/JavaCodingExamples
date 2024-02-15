package org.sourav.Leetcode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubstringWithDistinctChar {

    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("havefunonleetcode"));
    }

    public static int countGoodSubstrings(String s) {
        int k = 5;
        int count = 0;
        if (s.length() < k) {
            return count;
        }

        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < k; i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        if (freq.size() == k) {
            count++;
        }

        for (int i = 0; i < s.length() - k; i++) {
            char c = s.charAt(i);
            if (freq.get(c) == 1) {
                freq.remove(c);
            } else {
                freq.put(c, freq.get(c) - 1);
            }

            char d = s.charAt(i + k);
            freq.put(d, freq.getOrDefault(d, 0) + 1);

            if (freq.size() == k) {
                count++;
            }
        }

        return count;
    }

    private static  int traverseIntArray(int[] arr) {
        for (int i : arr) {
            if (i > 1) {
             return 0;
            }
        }

        return 1;
    }

}
