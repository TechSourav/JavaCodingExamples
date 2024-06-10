package org.sourav.Leetcode.Tree;

import java.util.LinkedList;

import org.sourav.practice.LL1;

public class Preorder {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<Integer>(2);
        root.left.left = new TreeNode<Integer>(3);
        root.right = new TreeNode<Integer>(4);
        root.right.left = new TreeNode<Integer>(5);
        root.right.right = new TreeNode<Integer>(6);

        LinkedList<Integer> ans = new LinkedList<>();
        preorder(root, ans);
        System.out.println(ans);
    }

    private static void preorder(TreeNode<Integer> root,  LinkedList<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.data);
        preorder(root.left, ans);
        preorder(root.right, ans);

    }

}
