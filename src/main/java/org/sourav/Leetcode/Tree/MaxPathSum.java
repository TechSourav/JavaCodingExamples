package org.sourav.Leetcode.Tree;

public class MaxPathSum {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(-10);
        root.left = new TreeNode<Integer>(9);
        root.right = new TreeNode<Integer>(20);
        root.right.left = new TreeNode<Integer>(15);
        root.right.right = new TreeNode<Integer>(7);

        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode<Integer> root) {
        int[] maxi = { 1 }; // Using an array to store the max value
        findMaxPathSum(root, maxi);
        return maxi[0];
    }

    private static int findMaxPathSum(TreeNode<Integer> node, int[] maxi) {
        if (node == null)
            return 0;

        int left = Math.max(0, findMaxPathSum(node.left, maxi));
        int right = Math.max(0, findMaxPathSum(node.right, maxi));

        maxi[0] = Math.max(maxi[0], left + right + node.data);

        return Math.max(left, right) + node.data;
    }

}
