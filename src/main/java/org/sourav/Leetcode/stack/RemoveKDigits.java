package org.sourav.Leetcode.stack;

import java.util.Stack;

public class RemoveKDigits {

    public static void main(String[] args) {
        System.out.println(removeKdigits("143229", 3));
    }

    public static String removeKdigits(String num, int k) {
        String s = "arn:aws:lambda:us-west-2:585460489129:function:playground-DDBEntityStaleRecordsCleanupLambda:DynamoDBEntityStaleRecordsCleanupLambdaAlias";
        System.out.println(s.length());
        int n = num.length();
        if (k >= n) {
            return "0";
        }
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char digit = num.charAt(i);

            while (k > 0 && result.length() > 0 && result.charAt(result.length() - 1) > digit) {
                result.deleteCharAt(result.length() - 1);
                k--;
            }
            result.append(digit);
        }
        result.delete(result.length() - k, result.length());

        int nonZeroIndex = 0;
        while (nonZeroIndex < result.length() && result.charAt(nonZeroIndex) == '0') {
            nonZeroIndex++;
        }

        return (nonZeroIndex == result.length()) ? "0" : result.substring(nonZeroIndex);
    }

}
