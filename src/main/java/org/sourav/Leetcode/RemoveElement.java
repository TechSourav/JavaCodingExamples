package org.sourav.Leetcode;

public class RemoveElement {

    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        int val = 2;

        System.out.println(removeElement(arr, val));
    }

    private static int removeElement(final int[] arr, final int val) {
        int r =0, w = 0;
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
        return w;

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
