package org.sourav.Leetcode.BinarySearch;

public class RotatedSortedArrSearchII {

    public static void main(String[] args) {
        int[] arr = {2,5,6,0,0,1,2};
        RotatedSortedArrSearchII rs = new RotatedSortedArrSearchII();
        System.out.println(rs.search(arr, 0));
    }

        public boolean search(int[] nums, int target) {
            int n = nums.length;
            if (n == 0)
                return false;

            int end = n - 1;
            int start = 0;

            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (nums[mid] == target) {
                    return true;
                }

                if (!isBinarySearchHelpful(nums, start, nums[mid])) {
                    start++;
                    continue;
                }

                // which array does pivot belong to.
                boolean pivotArray = existsInFirst(nums, start, nums[mid]);

                // which array does target belong to.
                boolean targetArray = existsInFirst(nums, start, target);

                // If pivot and target exist in different sorted arrays, recall that xor is true when both operands are distinct
                if (pivotArray ^ targetArray) {
                    if (pivotArray) {
                        start = mid + 1; // pivot in the first, target in the second
                    } else {
                        end = mid - 1; // target in the first, pivot in the second
                    }
                } else { // If pivot and target exist in same sorted array
                    if (nums[mid] < target) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
            return false;
        }

        // returns true if we can reduce the search space in current binary search space
        private boolean isBinarySearchHelpful(int[] arr, int start, int element) {
            return arr[start] != element;
        }

        // returns true if element exists in first array, false if it exists in second
        private boolean existsInFirst(int[] arr, int start, int element) {
            return arr[start] <= element;
        }
}
