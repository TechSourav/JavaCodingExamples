package org.sourav.recursion;

public class DecimalToBinary {

    public static void main(String[] args) {
        System.out.println(d2B(11));
    }

    private static String d2B(int n) {
        if (n == 0) {
            return "";
        }
        return d2B(n/2) + n % 2;
    }
}
