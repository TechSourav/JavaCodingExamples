package org.sourav.Leetcode.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InorderTraversal {

    public static void main(String[] args) {
        // Create a list of TreeNode objects to represent binary trees
        List<List<TreeNode<Integer>>> listOfTrees = Arrays.asList(
            Arrays.asList(new TreeNode<Integer>(3),
                new TreeNode<Integer>(2), new TreeNode<Integer>(17), new TreeNode<Integer>(1),
                new TreeNode<Integer>(4), new TreeNode<Integer>(19), new TreeNode<Integer>(5)),
            Arrays.asList(new TreeNode<Integer>(7),
                new TreeNode<Integer>(6), new TreeNode<Integer>(5), new TreeNode<Integer>(4),
                new TreeNode<Integer>(3), new TreeNode<Integer>(2), null, new TreeNode<Integer>(1)),
            Arrays.asList(new TreeNode<Integer>(5), new TreeNode<Integer>(4), new TreeNode<Integer>(6),
                new TreeNode<Integer>(3), new TreeNode<Integer>(2), new TreeNode<Integer>(7),
                new TreeNode<Integer>(8), new TreeNode<Integer>(1), new TreeNode<Integer>(9)),
            Arrays.asList(new TreeNode<Integer>(5), new TreeNode<Integer>(2), new TreeNode<Integer>(1),
                new TreeNode<Integer>(6), new TreeNode<Integer>(10), new TreeNode<Integer>(11),
                new TreeNode<Integer>(44)),
            Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(5),
                new TreeNode<Integer>(3), new TreeNode<Integer>(4), new TreeNode<Integer>(6)),
            Arrays.asList(new TreeNode<Integer>(-1), new TreeNode<Integer>(-2), null, new TreeNode<Integer>(-5),
                new TreeNode<Integer>(1), new TreeNode<Integer>(2), null, new TreeNode<Integer>(-6))
        );

        // Create the binary trees using the BinaryTree class
        List<BinaryTree<Integer>> inputTrees = new ArrayList<>();
        for (List<TreeNode<Integer>> ListOfNodes : listOfTrees) {
            BinaryTree<Integer> tree = new BinaryTree<>(ListOfNodes);
            inputTrees.add(tree);
        }

        // Print the input trees
        int x = 1;
        for (BinaryTree<Integer> tree : inputTrees) {
            System.out.println(x + ".\tBinary tree:");
            //Print.displayTree(tree.root, null);
            //flattenTree(tree.root);
            x++;
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
