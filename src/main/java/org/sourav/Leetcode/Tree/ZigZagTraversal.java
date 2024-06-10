package org.sourav.Leetcode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagTraversal {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<Integer>(2);
        root.left.left = new TreeNode<Integer>(3);
        root.right = new TreeNode<Integer>(4);
        root.right.left = new TreeNode<Integer>(5);
        root.right.right = new TreeNode<Integer>(6);

        System.out.println(zigzagLevelOrder(root));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode<Integer> root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        zigzag(root, list);
        return list;
    }

    public static void zigzag(TreeNode<Integer> root, List<List<Integer>> list) {
        if (root == null)
            return;

        Stack<TreeNode<Integer>> s1 = new Stack<>();
        Stack<TreeNode<Integer>> s2 = new Stack<>();
        s1.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> ans1 = new ArrayList<>();
            while (!s1.isEmpty()) {
                TreeNode<Integer> curr = s1.pop();
                if (curr.left != null)
                    s2.push(curr.left);
                if (curr.right != null)
                    s2.push(curr.right);
                ans1.add(curr.data);
            }
            System.out.println("ans1 : " + ans1);
            list.add(ans1);

            if (s1.isEmpty() && s2.isEmpty()) {
                break;
            }

            List<Integer> ans2 = new ArrayList<Integer>();
            while (!s2.isEmpty()) {
                TreeNode<Integer> curr = s2.pop();
                if (curr.right != null)
                    s1.push(curr.right);
                if (curr.left != null)
                    s1.push(curr.left);
                ans2.add(curr.data);
            }
            System.out.println("ans2 : " + ans2);
            list.add(ans2);
        }
    }
}
