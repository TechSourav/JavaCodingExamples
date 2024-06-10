package org.sourav.recursion;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,9,10};

        System.out.println(search(arr, 0, arr.length-1, 99));
    }

    private static boolean search(int[] arr, int l, int r, int target) {
        // base case 1
        if (arr.length ==  1) {
            if (arr[0] == target) {
                return true;
            }
            return false;
        }

        // base case 2
        if (l == r) {
            if (arr[l] == target) {
                return true;
            }
            return false;
        }

        // base case 3
        if (l > r) {
          return false;
        }

        int mid = (l+r)/2;
        if (arr[mid] == target) {
            return true;
        }

        return search(arr, mid + 1, r, target) || search(arr, l, mid-1, target);
    }

}
