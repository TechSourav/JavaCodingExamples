package org.sourav.Leetcode.CyclicSort;

public class MissingPositive {

    public static void main(String[] args) {
        int[] arr = {3,5,-1,1};
        System.out.println(firstMissingPositive(arr));
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Base case.
        int contains = 0;
        for (int i = 0; i < n; i++)
            if (nums[i] == 1) {
                contains++;
                break;
            }

        if (contains == 0)
            return 1;

        /*
         * Replace negative numbers, zeros, and numbers larger than n by 1s.
         * After this conversion nums will contain only positive numbers.
         */
        for (int i = 0; i < n; i++)
            if ((nums[i] <= 0) || (nums[i] > n))
                nums[i] = 1;

        /*
         * Use index as a hash key and number sign as a presence detector.
         * For example, if nums[1] is negative that means that number `1` is present in the array.
         * If nums[2] is positive - number 2 is missing.
         */
        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            /*
             * If you meet number a in the array - change the sign of a-th element.
             * Be careful with duplicates : do it only once.
             */
            if (a == n)
                /*
                 * Use index 0 to save information about the presence of
                 * number n since index n is not available
                 */
                nums[0] = - Math.abs(nums[0]);
            else
                nums[a] = - Math.abs(nums[a]);
        }

        // Now the index of the first positive number
        // is equal to first missing positive.
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0)
                return i;
        }

        // If this condition is true, means there is not element equals to 'n'.
        if (nums[0] > 0)
            return n;

        return n + 1;
    }
}
