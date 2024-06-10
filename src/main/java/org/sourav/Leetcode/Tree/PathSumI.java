package org.sourav.Leetcode.Tree;

import java.util.Stack;

public class PathSumI {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(5);
        root.left = new TreeNode<Integer>(4);
        root.left.left = new TreeNode<Integer>(11);
        root.left.left.left = new TreeNode<Integer>(7);
        root.left.left.right = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(8);
        root.right.left = new TreeNode<Integer>(13);
        root.right.right = new TreeNode<Integer>(4);
        root.right.right.right = new TreeNode<>(1);

        System.out.println(hasPathSum(root, 22));
    }

    public static boolean hasPathSum(TreeNode<Integer> root, int sum) {
        Stack<TreeNode<Integer>> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        nodeStack.push(root);
        sumStack.push(sum - root.data);

        while (!nodeStack.isEmpty()) {
            TreeNode<Integer> node = nodeStack.pop();
            int currSum = sumStack.pop();
            if (node.left == null && node.right == null && currSum == 0) {
                return true;
            }
            if (node.left != null) {
                nodeStack.push(node.left);
                sumStack.push(currSum - node.left.data);
            }
            if (node.right != null) {
                nodeStack.push(node.right );
                sumStack.push(currSum - node.right .data);
            }
        }
        return false;

    }

}
