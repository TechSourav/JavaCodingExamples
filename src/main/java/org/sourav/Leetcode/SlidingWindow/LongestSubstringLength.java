package org.sourav.Leetcode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringLength {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int length = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (!map.containsKey(c)) {
                map.put(c, r);
                length = Math.max(length, r - l + 1);
            } else {
                l =  map.get(c) >= l ? map.get(c) + 1 : l;
                map.remove(c);
                map.put(c, r);
                length = Math.max(length, r - l + 1);
            }

        }
        return length;
    }

}
