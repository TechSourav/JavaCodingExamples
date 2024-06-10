package org.sourav.recursion;

public class CheckPrime {

    public static void main(String[] args) {
        System.out.println(isPrime(5));
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        return checkDivisors(n, 2);
    }

    private static boolean checkDivisors(int number, int divisor) {
        if (divisor > Math.sqrt(number)) {
            return true;
        }
        if (number % divisor == 0) {
            return false;
        }
        return checkDivisors(number, divisor + 1);
    }
}
