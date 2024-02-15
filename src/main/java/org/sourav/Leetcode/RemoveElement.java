package org.sourav.Leetcode;

public class RemoveElement {

    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        int val = 2;

        System.out.println(removeElement(arr, val));
    }

    private static int removeElement(final int[] nums, final int val) {
        int i = 0, j = 0;

        while (i < nums.length && j < nums.length) {
            if (nums[j] == val) {
                j++;
            } else if (nums[j] != val && i < j) {
                nums[i] = nums[j];
                nums[j] = val; // {0,1,3,0,4,2,2,2}
                i++;
                j = i;
            } else {
                i++;
                j++;
            }
        }
        return i;

       /* int r =0, w = 0;
        int n = arr.length;

        while (r < n) {
            if (arr[r] == val) {
                r++;
            } else {
                arr[w] = arr[r];
                r++;
                w++;
            }

        }
        return w;*/

        /*int index = 0;
        for(int i = 0; i< arr.length; i++){
            if(arr[i] != val){
                arr[index] = arr[i];
                index++;
            }
        }
        return index;*/
    }

}
