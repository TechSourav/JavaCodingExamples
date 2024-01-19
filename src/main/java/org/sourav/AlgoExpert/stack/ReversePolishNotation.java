package org.sourav.AlgoExpert.stack;

import java.util.Set;
import java.util.Stack;

public class ReversePolishNotation {

    private static String OPERATORS = "+,-,*,/";

    public static void main(String[] args) {
        String[] tokens = new String[] {"50", "3","17", "+","2", "-","/"};
        ReversePolishNotation rpn = new ReversePolishNotation();
        System.out.println(rpn.reversePolishNotation(tokens));
    }

    public int reversePolishNotation(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String currVal : tokens) {
            if (!OPERATORS.contains(currVal)) {
                st.push(Integer.valueOf(currVal));
            } else {
                int val1 = st.pop();
                int val2 = st.pop();
                switch (currVal) {
                case "+":
                    int res1 = val2 + val1;
                    st.push(res1);
                    break;
                case "-":
                    int res2 = val2 - val1;
                    st.push(res2);
                    break;
                case "*":
                    int res3 = val2 * val1;
                    st.push(res3);
                    break;
                case "/":
                    int res4 = val2 / val1;
                    st.push(res4);
                    break;
                default:
                    throw new RuntimeException("invalid operator");
                }
            }
        }
        return st.pop();
    }

}
