package org.sourav.Leetcode;

public class SIngleNumber {

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        int count = 0;
        for (int n : nums) {
            count ^= n;
        }
        System.out.println(count);
    }

}
