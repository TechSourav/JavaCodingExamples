package org.product2;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        int[] arr = {-1,0,1,-2,5,7,-9};

        Arrays.sort(arr);

        List<Integer> lowestProductSubset = new ArrayList<>();
        int[] minProd = {Integer.MAX_VALUE}; // Using an array to pass by reference
        printSubsets(arr, lowestProductSubset, new ArrayList<>(), minProd, 0);

        System.out.println("Subset with lowest product: " + lowestProductSubset);
    }

    /*public static void main(String[] args) {
        int[] arr = {-1,0,1,-2,5,7,-9};

        Arrays.sort(arr); // -9 -2 -1 0 1 5 7

        List<List<Integer>> result = new ArrayList<>();
        printSubsets(arr, result, new ArrayList<>(), Integer.MAX_VALUE, 0);
        System.out.println(result);
    }

    private static void printSubsets2(int[] arr, List<List<Integer>> result, List<Integer> tempList, int minProd, int index) {
        int currProd = 1;
        for (int n : tempList) {
            currProd = currProd * n;
        }

        if (minProd > currProd) {
            minProd = currProd;
            result.clear();
            result.add(new ArrayList<>(tempList));
        }

        for (int i = index; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }
            //product = product * arr[i];
            tempList.add(arr[i]);

            printSubsets(arr, result, tempList, minProd, i+1);
            tempList.remove(tempList.size() - 1);
        }

    }*/

    private static void printSubsets(int[] arr, List<Integer> lowestProductSubset, List<Integer> tempList, int[] minProd, int index) {
        int currProd = 1;
        for (int n : tempList) {
            currProd *= n;
        }

        if (minProd[0] > currProd) {
            minProd[0] = currProd;
            lowestProductSubset.clear();
            lowestProductSubset.addAll(tempList);
        }

        for (int i = index; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }
            tempList.add(arr[i]);

            printSubsets(arr, lowestProductSubset, tempList, minProd, i + 1);

            tempList.remove(tempList.size() - 1);
        }
    }
}
