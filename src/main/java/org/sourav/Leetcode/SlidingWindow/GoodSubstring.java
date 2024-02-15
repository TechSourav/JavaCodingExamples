package org.sourav.Leetcode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class GoodSubstring {

    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("aababcabc"));
    }

    public static int countGoodSubstrings(String s) {
        int k = 3;
        if (s.length() < k) {
            return 0;
        }
        final Map<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < k; i++)
        {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (map.size() == k) {
            count++;
        }

        for (int i = 0; i < s.length() - k; i++)
        {
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            if (map.get(s.charAt(i)) == 0) {
                map.remove(s.charAt(i));
            }

            map.put(s.charAt(i+k), map.getOrDefault(s.charAt(i+k), 0) + 1);

            if (map.size() == k) {
                count++;
            }
        }

        return count;
    }

}
