package org.sourav.Leetcode.TopKElements;

import java.util.PriorityQueue;

public class ReorganizeString {

    public static void main(String[] args) {
        System.out.println(reorganizeString2("aaab"));
    }

    public static String reorganizeString(String s) {
        int[] charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        // Max heap ordered by character counts
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[1], a[1]));
        for (int i = 0; i < 26; i++) {
            if (charCounts[i] > 0) {
                pq.offer(new int[] {i + 'a', charCounts[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char) first[0]);
                if (--first[1] > 0) {
                    pq.offer(first);
                }
            } else {
                if (pq.isEmpty()) {
                    return "";
                }

                int[] second = pq.poll();
                sb.append((char) second[0]);
                if (--second[1] > 0) {
                    pq.offer(second);
                }

                pq.offer(first);
            }
        }

        return sb.toString();
    }

    public static String reorganizeString2(String s) {
        int[] charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        int maxCount = 0, letter = 0;
        for (int i = 0; i < charCounts.length; i++) {
            if (charCounts[i] > maxCount) {
                maxCount = charCounts[i];
                letter = i;
            }
        }

        if (maxCount > (s.length() + 1) / 2) {
            return "";
        }

        char[] ans = new char[s.length()];
        int index = 0;

        // Place the most frequent letter
        while (charCounts[letter] != 0) {
            ans[index] = (char) (letter + 'a');
            index += 2;
            charCounts[letter]--;
        }

        // Place rest of the letters in any order
        for (int i = 0; i < charCounts.length; i++) {
            while (charCounts[i] > 0) {
                if (index >= s.length()) {
                    index = 1;
                }
                ans[index] = (char) (i + 'a');
                index += 2;
                charCounts[i]--;
            }
        }

        return String.valueOf(ans);
    }

}
