package org.sourav.AlgoExpert.tree;

import java.util.Arrays;
import java.util.List;

public class MinHeightBST {

    public static void main(String[] args) {
        BST tree = minHeightBst(Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22));
        System.out.println(tree);
    }

    public static BST minHeightBst(List<Integer> arr) {
        int size = arr.size();
        if (size == 0)
            return null;

        int mid = size/2;

        final BST bst = new BST(arr.get(mid));
        bst.left = minHeightBst(arr.subList(0,mid));
        bst.right = minHeightBst(arr.subList(mid+1, size));
        return bst;
    }

}
