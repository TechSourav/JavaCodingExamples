package org.sourav.Leetcode.Subsets;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> resultList = new ArrayList<>();
        backTrack(resultList, s.toCharArray(), 0);
        return resultList;
    }

    private static void backTrack(List<String> ans,  char[] arr, int i) {
        // If length is equal to the index, add the string to the ans list.
        if (i == arr.length) {
            ans.add(new String(arr));
            return;
        }
        // if digit, simply move to the next character.
        if (Character.isDigit(arr[i])) {
            backTrack(ans, arr, i+1);
            return;
        } else { // if a letter, then convert to upper/ lower and move on.
            arr[i] = Character.toUpperCase(arr[i]);
            backTrack(ans, arr, i+1);

            arr[i] = Character.toLowerCase(arr[i]);
            backTrack(ans, arr, i+1);
        }
    }

}
