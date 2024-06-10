package org.sourav.Leetcode.KWay;

public class MergeTwoArrays {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};
        merge(arr1, 3, arr2, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int r1 = m - 1;
        int r2 = n - 1;

        for (int w = m + n - 1; w >=0; w--) {
            if (r1 >= 0 && r2 >= 0) {
                nums1[w] = nums1[r1] > nums2[r2] ? nums1[r1--] : nums2[r2--];
            } else if (r1 >= 0) {
                nums1[w] = nums1[r1--];
            } else {
                nums1[w] = nums2[r2--];
            }
        }

    }

}
