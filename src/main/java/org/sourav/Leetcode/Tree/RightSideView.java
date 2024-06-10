package org.sourav.Leetcode.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<Integer>(2);
        root.left.left = new TreeNode<Integer>(3);
        root.right = new TreeNode<Integer>(4);
        root.right.left = new TreeNode<Integer>(5);
        root.right.right = new TreeNode<Integer>(6);

        //System.out.println(rightSideView2(root));

        RightSideView rv = new RightSideView();
        System.out.println(rv.rightSideView3(root));
    }

    public static List<Integer> rightSideView(TreeNode<Integer> root) {
        if (root == null)
            return new ArrayList<Integer>();

        ArrayDeque<TreeNode<Integer>> nextLevel = new ArrayDeque() {{
            offer(root);
        }};
        ArrayDeque<TreeNode<Integer>> currLevel = new ArrayDeque();
        List<Integer> rightside = new ArrayList();

        TreeNode<Integer> node = null;
        while (!nextLevel.isEmpty()) {
            // prepare for the next level
            currLevel = nextLevel;
            nextLevel = new ArrayDeque<>();

            while (!currLevel.isEmpty()) {
                node = currLevel.poll();

                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null)
                    nextLevel.offer(node.left);
                if (node.right != null)
                    nextLevel.offer(node.right);
            }

            // The current level is finished.
            // Its last element is the rightmost one.
            if (currLevel.isEmpty())
                rightside.add(node.data);
        }
        return rightside;
    }

    public static List<Integer> rightSideView2(TreeNode<Integer> root) {
        if (root == null) return new ArrayList<Integer>();

        Queue<TreeNode<Integer>> queue = new LinkedList(){{ offer(root); offer(null); }};
        TreeNode<Integer> prev, curr = root;
        List<Integer> rightside = new ArrayList();

        while (!queue.isEmpty()) {
            prev = curr;
            curr = queue.poll();

            while (curr != null) {
                // add child nodes in the queue
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }

                prev = curr;
                curr = queue.poll();
            }

            // the current level is finished
            // and prev is its rightmost element
            rightside.add(prev.data);

            // add a sentinel to mark the end
            // of the next level
            if (!queue.isEmpty())
                queue.offer(null);
        }
        return rightside;
    }

    List<Integer> rightside = new ArrayList();

    public void helper(TreeNode<Integer> node, int level) {
        if (level == rightside.size())
            rightside.add(node.data);

        if (node.right != null)
            helper(node.right, level + 1);
        if (node.left != null)
            helper(node.left, level + 1);
    }

    public List<Integer> rightSideView3(TreeNode<Integer> root) {
        if (root == null)
            return rightside;

        helper(root, 0);
        return rightside;
    }

}
