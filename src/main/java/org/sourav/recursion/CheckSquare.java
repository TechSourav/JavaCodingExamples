package org.sourav.recursion;

public class CheckSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(19));
    }

    public static boolean isPerfectSquare(int num) {
        return isPerfectSquareHelper(num, 0, num);
    }

    private static boolean isPerfectSquareHelper(int num, int low, int high) {
        if (low > high) {
            return false;
        }

        int mid = low + (high - low) / 2;

        if ((long) mid * mid == num) {
            return true;
        }
        if ((long) mid * mid > num) {
            return isPerfectSquareHelper(num, low, mid - 1);
        } else {
            return isPerfectSquareHelper(num, mid + 1, high);
        }
    }

}
