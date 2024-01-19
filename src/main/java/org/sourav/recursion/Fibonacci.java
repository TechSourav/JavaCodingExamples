package org.sourav.recursion;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(getNthFib(6));
    }

    public static int getNthFib(int n) {
        if (n ==0)
            return 0;
        else if (n==1)
            return 0;
        else if (n==2)
            return 1;
        else
            return getNthFib(n-1) + getNthFib(n-2);
    }
}
