package org.sourav.Leetcode.stack;

import java.util.*;

public class PreviousGreaterElement {

    public static void main(String[] args) {
        int[] a = {4,5,2,25};
        System.out.println(Arrays.toString(previousLargerElement(a)));
    }

    public static int[] previousLargerElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] op = new int[arr.length];

        for (int i = 0; i <= arr.length - 1; i++) {
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
