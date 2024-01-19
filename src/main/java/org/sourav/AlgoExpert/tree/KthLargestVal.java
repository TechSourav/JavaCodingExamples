package org.sourav.AlgoExpert.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthLargestVal {

    public static void main(String[] args) {
        BST nodes = MinHeightBST.minHeightBst(Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22));
        System.out.println(findKthLargestValueInBst(nodes, 3));
    }

    public static int findKthLargestValueInBst(BST tree, int k) {
        if (tree == null) {
            return -1;
        }

        final List<Integer> node = new ArrayList<>();

        inorder(tree, node);

        return node.get(node.size() - k);
    }

    public static void inorder(BST tree, List<Integer> nodes) {
        if (tree == null) {
            return;
        }

        inorder(tree.left, nodes);

        nodes.add(tree.value);

        inorder(tree.right, nodes);

    }

}
