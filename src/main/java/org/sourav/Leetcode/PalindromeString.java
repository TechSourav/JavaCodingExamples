package org.sourav.Leetcode;

import java.util.Arrays;

public class PalindromeString {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static  boolean isPalindrome(String s) {
        if (s.equals(" ")) {
            return true;
        }
        char[] arr = s.toLowerCase().toCharArray();

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            if (!Character.isLetterOrDigit(arr[i])) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(arr[j])) {
                j--;
                continue;
            }

            if (arr[i] == arr[j]) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;

    }

}
