package org.sourav.Leetcode;

public class FindFirstOccurance {

    public static void main(String[] args) {
        System.out.println(strStr("abc", "c"));
    }

    public static int strStr(String haystack, String needle) {
        int lenn = needle.length();
        int lenh = haystack.length();
        if (lenn > lenh) {
            return -1;
        }
        for (int i = 0; i <= lenh - 1; i++) {
            if (lenh - i < lenn) {
                return -1;
            }
            String s = haystack.substring(i, i + lenn);
            if (s.equals(needle)){
                return i;
            }
        }

        return -1;
    }
}
