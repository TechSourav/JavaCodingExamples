package org.sourav.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }

    // Approach 1
    public static int lengthOfLongestSubstring(final String s) {
        Integer[] chars = new Integer[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);

            Integer index = chars[r];
            if (index != null && index >= left && index < right) {
                left = index + 1;
            }

            res = Math.max(res, right - left + 1);

            chars[r] = right;
            right++;
        }

        return res;
    }

    // Approach 2
    public static int lengthOfLongestSubstring2(final String s) {
        final Map<Character, Integer> map = new HashMap<>();
        int ans = 0;

        for (int left=0,right=0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(map.get(c), left);
            }

            ans =  Math.max(ans, right - left + 1);
            map.put(c, right + 1);
        }
        return ans;
    }
}
