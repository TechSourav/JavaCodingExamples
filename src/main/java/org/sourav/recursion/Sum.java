package org.sourav.recursion;

public class Sum {

    public static void main(String[] args) {
        System.out.println(printSum(10));
    }

    private static int printSum(int n) {
        if (n == 1) {
            return 1;
        }
        int sum = n + printSum(n-1);
        return sum;
    }

}
