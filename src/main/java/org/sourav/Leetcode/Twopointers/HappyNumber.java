package org.sourav.Leetcode.Twopointers;

// Floyd's tortoise and hare method will be used, because this has something to do with a cycle.
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(5));
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        while (true) {
            slow = sumCompute(slow);
            fast = sumCompute(sumCompute(fast));
            if (slow == fast) {
                break;
            }
        }
        return slow == 1;
    }

    public static int sumCompute(int n) {
        int sumValue = 0;
        while (n > 0) {
            int digit = n % 10;
            sumValue += digit * digit;
            n /= 10;
        }
        return sumValue;
    }

}
