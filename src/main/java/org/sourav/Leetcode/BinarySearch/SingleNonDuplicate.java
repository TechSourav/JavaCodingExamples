package org.sourav.Leetcode.BinarySearch;

public class SingleNonDuplicate {

    public static void main(String[] args) {
        //int[] arr = {1,1,4,4,5,5,6,6,8,9,9};
        int[] arr = {1,1,2,2,3,3,4,8,8};
        System.out.println(singleNonDuplicate(arr));
    }

    public static int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            boolean halvesAreEven = (hi - mid) % 2 == 0;
            // Check if right side has the other pair number.
            if (nums[mid + 1] == nums[mid]) {
                // If halves are even and since we are on the right side, we should increase 'lo' by 2.
                if (halvesAreEven) {
                    lo = mid + 2;
                } // If halves are odd and since we are on the right side, we should decrease 'hi' by 1.
                else {
                    hi = mid - 1;
                }
            } // Check if left side has the other pair number.
            else if (nums[mid - 1] == nums[mid]) {
                // If halves are even and since we are on the left side, we should decrease 'hi' by 2.
                if (halvesAreEven) {
                    hi = mid - 2;
                } // If halves are odd and since we are on the left side, we should increase 'lo' by 1.
                else {
                    lo = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[lo];
    }
}
