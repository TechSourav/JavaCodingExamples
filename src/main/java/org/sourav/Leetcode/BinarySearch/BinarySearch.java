package org.sourav.Leetcode.BinarySearch;

public class BinarySearch {

    public static void main(String[] args) {
        char[] a = {'b','c','e','k'};
        System.out.println(nextGreatestLetter(a, 'a'));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // If left == letters.length, it means there is no character in letters
        // that is lexicographically greater than target. so return letters[0].
        // Else, we return letters[left] as left holds the smallest character.
        return left == letters.length ? letters[0] : letters[left];
    }

}
