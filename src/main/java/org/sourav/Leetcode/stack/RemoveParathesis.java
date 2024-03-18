package org.sourav.Leetcode.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class RemoveParathesis {

    // Driver code
    public static void main(String[] args) {

        List<String> inputs = Arrays.asList("lee(t(c)o)de)", "ar)ab(abc)abd(", "a)rt)lm(ikgh)", "aq)xy())qf(a(ba)q)",
            "(aw))kk())(w(aa)(bv(wt)r)",  "(qi)(kl)((y(yt))(r(q(g)s)");
        for (int i = 0; i < inputs.size(); i++) {
            System.out.println(Integer.toString(i + 1) + ". Input: " + inputs.get(i));
            System.out.println("   Valid parentheses, after minimum removal: "
                + minRemoveParentheses(inputs.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static String minRemoveParentheses(String s) {
        // Stack to store teh invalid paranthesis.
        Stack<int[]> stack = new Stack<>();
        // Taking an array in order to remove the incorrect paranthesis from the array.
        char[] sArray = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            char val = s.charAt(i);
            if (!stack.isEmpty() && stack.peek()[0] == '(' && val == ')') {
                stack.pop();
            } else if (val == '(' || val == ')') {
                stack.push(new int[]{val, i});
            }
        }

        // Replacing the incorrect paranthesis with empty character ' '.
        while (!stack.isEmpty()) {
            sArray[stack.pop()[1]] = ' ';
        }

        // Add back all the characters.
        StringBuilder result = new StringBuilder();
        for (char c : sArray) {
            if (c != ' ') {
                result.append(c);
            }
        }

        return result.toString();
    }

}
