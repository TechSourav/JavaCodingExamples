package org.sourav.Leetcode;

public class ValidPalinAfterSkipping {

    public static void main(String[] args) {
        System.out.println(validPalindrome("abaeba"));
    }

    public static boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                if (isPalindrome(s,l+1,r)) {
                    return true;
                }
                return isPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }

        return true;

    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
