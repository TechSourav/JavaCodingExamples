package org.sourav.Leetcode;

public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagamra"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] n1 = new int[26];

        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            n1[ch1[i] - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            n1[ch2[i] - 'a']--;
        }

        int c = 0;

        for (int j : n1) {
            if (j > 0) {
                c++;
            }
        }

        if (c > 0) {
            return false;
        }
        return true;
    }

}
