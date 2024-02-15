package org.sourav.Leetcode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinWIndowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        final Map<Character, Integer> charMapT = new HashMap<>();
        for (char c : t.toCharArray()) {
            charMapT.put(c, charMapT.getOrDefault(c, 0) + 1);
        }

        int matched = 0;
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            final char currentCharS = s.charAt(windowEnd);

            if (charMapT.containsKey(currentCharS)) {
                charMapT.put(currentCharS, charMapT.get(currentCharS) - 1);
                // If charMapT has 0 of the current character, meaning one match is found.
                if (charMapT.get(currentCharS) == 0) {
                    matched++;
                }
            }

            while (matched == charMapT.size()) {
                int windowSize = windowEnd - windowStart + 1;

                if (windowSize < minLength) {
                    minLength = windowSize;
                    minStart = windowStart;
                }

                final char charToRemoveS = s.charAt(windowStart);

                if (charMapT.containsKey(charToRemoveS)) {
                    if (charMapT.get(charToRemoveS) == 0) {
                        matched--;
                    }
                    charMapT.put(charToRemoveS, charMapT.get(charToRemoveS) + 1);
                }

                windowStart++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minStart, minStart + minLength);
    }
}
