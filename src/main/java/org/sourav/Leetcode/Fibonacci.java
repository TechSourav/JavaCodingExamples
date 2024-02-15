package org.sourav.Leetcode;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fib(5));
    }

    private static int fib(final int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        int one_step_before = 1;
        int two_steps_before = 0;
        int f = 1;

        for(int i=1; i<n; i++){
            f = one_step_before + two_steps_before;
            two_steps_before = one_step_before;
            one_step_before = f;
        }

        return f;
    }

}
