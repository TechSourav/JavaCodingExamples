package org.sourav.Leetcode.SlidingWindow;

public class LongestRepeatingCharReplacement {

    public static void main(String[] args) {
        System.out.println(characterReplacement("aabccbb", 2));
    }

    public static int characterReplacement(String s, int k) {
        int l = 0, r = 1;
        char maxChar;
        int maxLen = 0;
        int temp = k;

        while (r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                r++;
            }
            if (s.charAt(l) != s.charAt(r) && temp > 0) {
                temp--;
                if (temp > 0) {
                    r++;
                }
            }
            if ((r - l +1) > maxLen && temp == 0) {
                maxChar = s.charAt(l);
                maxLen = Math.max(maxLen, r - l +1);
                temp = k; // reinstate temp
                while (s.charAt(l) == maxChar) {
                    l++;
                }
                r = l;
            }
        }
        return maxLen;
    }

}
