package org.sourav.Leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traversals {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<Integer>(2);
        root.left.left = new TreeNode<Integer>(3);
        root.right = new TreeNode<Integer>(4);
        root.right.left = new TreeNode<Integer>(5);
        root.right.right = new TreeNode<Integer>(6);

        System.out.println("********* Inorder traversal DFS ******************");
        LinkedList<Integer> ans = new LinkedList<>();
        inorderDFS(root, ans);
        System.out.println(ans);
        System.out.println("********* Preorder traversal DFS ******************");
        LinkedList<Integer> ans2 = new LinkedList<>();
        preorderDFS(root, ans2);
        System.out.println(ans2);
        System.out.println("********* Postorder traversal DFS ******************");
        LinkedList<Integer> ans3 = new LinkedList<>();
        postorderDFS(root, ans3);
        System.out.println(ans3);
        System.out.println("********* Preorder traversal BFS ******************");
        LinkedList<Integer> ans4 = new LinkedList<>();
        preorderBFS(root, ans4);
        System.out.println(ans4);
        System.out.println("********* Level traversal ******************");
        List<List<Integer>> ans5 = levelorderDFS(root);
        System.out.println(ans5);
    }

    private static void inorderDFS(TreeNode<Integer>root, LinkedList<Integer> ans) {
        if (root == null) {
            return;
        }
        inorderDFS(root.left, ans);
        ans.add(root.data);
        inorderDFS(root.right, ans);
    }

    private static void preorderDFS(TreeNode<Integer>root, LinkedList<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.data);
        preorderDFS(root.left, ans);
        preorderDFS(root.right, ans);
    }

    private static void postorderDFS(TreeNode<Integer>root, LinkedList<Integer> ans) {
        if (root == null) {
            return;
        }
        postorderDFS(root.left, ans);
        postorderDFS(root.right, ans);
        ans.add(root.data);
    }

    // .......................................................................................................................................


    private static void preorderBFS(TreeNode<Integer>root, LinkedList<Integer> ans) {
        if (root == null) {
            return;
        }
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode<Integer> node = q.poll();
            ans.add(node.data);
            if (node.left != null) {
                q.offer(node.left);
            }

            if (node.right != null) {
                q.offer(node.right);
            }
        }
    }

    private static List<List<Integer>> levelorderDFS(TreeNode<Integer>root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return List.of();
        }

        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode<Integer> node = q.poll();
                level.add(node.data);

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }

}
