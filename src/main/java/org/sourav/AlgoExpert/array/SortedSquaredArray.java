package org.sourav.AlgoExpert.array;

public class SortedSquaredArray {

    public static void main(String[] args) {
        final int[] arr = {-7,1,2,3,5,6,8,9};
        int[] res = sortedSquaredArray(arr);
    }

    public static int[] sortedSquaredArray(int[] array) {
        int[] arr2 = new int[array.length];
        int left = 0;
        int right = array.length - 1;
        int i = array.length - 1;

        while (left <= right) {
            if (Math.abs(array[left]) < Math.abs(array[right])) {
                arr2[i] = array[right] * array[right];
                right--;
                i--;
            } else  {
                arr2[i] = array[left] * array[left];
                left++;
                i--;
            }
        }
        return arr2;
    }

}
