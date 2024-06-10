package org.sourav.Leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthOfTree {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<Integer>(2);
        root.left.left = new TreeNode<Integer>(3);
        root.right = new TreeNode<Integer>(4);
        root.right.left = new TreeNode<Integer>(5);

        System.out.println(minDepth(root));
    }

    private static int minDepth(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;

        while (!q.isEmpty()) {
            int len = q.size();

            while (len > 0) {
                len--;
                TreeNode<Integer> n = q.poll();
                // Since we added nodes without checking null, we need to skip them here.
                if (n == null) {
                    continue;
                }

                // The first leaf would be at minimum depth, hence return it.
                if (n.left == null && n.right == null) {
                    return depth;
                }

                q.add(n.left);
                q.add(n.right);
            }
            depth++;
        }
        return -1;
    }

}
