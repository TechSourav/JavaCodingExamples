package org.sourav.Leetcode.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class GreaterElement1 {

    public static void main(String[] args) {
        int[] n1 = {4,1,2};
        int[] n2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(n1, n2)));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.empty() && nums2[i] > stack.peek())
                map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }

        while (!stack.empty())
            map.put(stack.pop(), -1);

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }
}
