package org.sourav.Leetcode.Tree;

public class ValidateBST {
    
    public static boolean validate(TreeNode<Integer> root, Integer low, Integer high) {
        // Empty trees are valid BSTs.
        if (root == null) {
            return true;
        }

        // The current node's value must be between low and high.
        if ((low != null && root.data <= low) || (high != null && root.data >= high)) {
            return false;
        }

        // The left and right subtree must also be valid.
        return validate(root.right, root.data, high) && validate(root.left, low, root.data);
    }

    public static boolean isValidBST(TreeNode<Integer> root) {
        return validate(root, null, null);
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode<Integer>(4);
        root.left.left = new TreeNode<Integer>(3);
        root.right = new TreeNode<Integer>(14);
        root.right.left = new TreeNode<Integer>(7);
        root.right.right = new TreeNode<Integer>(16);

        System.out.println(isValidBST(root));
    }
}
