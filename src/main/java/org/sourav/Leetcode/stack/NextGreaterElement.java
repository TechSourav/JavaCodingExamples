package org.sourav.Leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] a = {4,5,2,25};
        System.out.println(Arrays.toString(nextGreater(a)));
    }

    public static int[] nextGreater(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] op = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                op[i] = -1;
            } else if (st.peek() > arr[i]) {
                op[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return op;
    }

}
