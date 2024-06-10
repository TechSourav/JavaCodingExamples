package org.sourav.Leetcode.Tree;

public class LCA {

    private TreeNode<Integer> ans;

    public LCA() {
        // Variable to store LCA node.
        this.ans = null;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<Integer>(2);
        root.left.left = new TreeNode<Integer>(3);
        root.right = new TreeNode<Integer>(4);
        root.right.left = new TreeNode<Integer>(5);
        root.right.right = new TreeNode<Integer>(6);

        LCA lca = new LCA();
        System.out.println(lca.lowestCommonAncestor(root, root.left.left,root.right.right).data);
    }

    private boolean recurseTree(TreeNode<Integer> currentNode, TreeNode<Integer> p, TreeNode<Integer> q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }
}
