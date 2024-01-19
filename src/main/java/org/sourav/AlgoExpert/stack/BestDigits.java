package org.sourav.AlgoExpert.stack;

import java.util.Stack;
import java.util.stream.Collectors;

public class BestDigits {

    public static void main(String[] args) {
        String s = "22";
        int n = 1;
        System.out.println(bestDigits(s, n));
    }

    // Approach 1:
    /*public static String bestDigits(String number, int numDigits) {
        Stack<Integer> st = new Stack<>();
        char[] ch = number.toCharArray();
        for (char i : ch) {
            int x = Character.getNumericValue(i);
            if (st.isEmpty()) {
                st.push(x);
            } else {
                while (!st.isEmpty() && st.peek() <= x && numDigits > 0) {
                    st.pop();
                    numDigits--;
                }
                if (st.size() != number.length() - numDigits)
                    st.push(x);
            }
        }

        return st.stream().map(Object::toString).collect(Collectors.joining(""));
    }*/

    // Approach 2:
    public static String bestDigits(String number, int numDigits) {
        final char[] array = number.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            while (slow >=1 && numDigits > 0 && array[fast] > array[slow-1]) {
                slow--;
                numDigits--;
            }
            array[slow++] = array[fast];
        }

        while (numDigits > 0) {
            slow--;
            numDigits--;
        }

        return new String(array, 0, slow);
    }

}
