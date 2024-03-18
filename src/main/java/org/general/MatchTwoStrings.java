package org.general;

import java.util.Arrays;

class MatchTwoStrings {

    public static void main(String[] args) {
        System.out.println(getMatchingFreq("abbccc", "bbbaad"));
    }

    private static boolean getMatchingFreq(String w1, String w2) {
        if (w1.length() != w2.length()){
            return false;
        }

        int[] arr1 = new int[26]; // 0
        int[] arr2 = new int[26]; // 0

        for (int i = 0; i < w1.length(); i++) {
            char cur = w1.charAt(i);
            arr1[cur - 'a']++; // 1, 0, 2,...26
        }

        for (int i = 0; i < w2.length(); i++) {
            char cur = w2.charAt(i);
            arr2[cur - 'a']++;
        }

        for (int j = 0; j < arr1.length; j++) {
            if ((arr1[j] > 0 && arr2[j] == 0) || (arr1[j] == 0 && arr2[j] > 0)) {
                return false;
            }
        }

        // sort the two ARRAYS
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);

    }
}
