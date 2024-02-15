package org.sourav.Leetcode;

public class PalindromeNum {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));

    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int sum = 0;
        int num = x;
        while (num > 0) {
            int rem = num % 10;
            sum = sum * 10 + rem;
            num = num/10;
        }

        if (sum == x) {
            return true;
        }
        return false;

    }
}
