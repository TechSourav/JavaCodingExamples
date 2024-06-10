package org.sourav.Leetcode.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrder {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<Integer>(2);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(5);
        root.right = new TreeNode<Integer>(3);
        root.right.left = new TreeNode<Integer>(6);
        root.right.right = new TreeNode<Integer>(7);

        System.out.println(verticalOrder(root));
    }

    private static List<List<Integer>> verticalOrder(TreeNode<Integer> root) {
        final List<List<Integer>> ans = new ArrayList<>();
        //map to track nodes for each HD
        final Map<Integer,List<Integer>> map = new TreeMap<>();
        Queue<TreeNode<Integer>> q = new LinkedList<>();

        if (root == null) {
            return ans;
        }

        q.offer(root);

        //index of each nodes stored in q(queues)
        Queue<Integer> indices = new LinkedList < > ();
        indices.offer(0);

        int minIndex = 0, maxIndex = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node = q.poll();
                int index = indices.poll();
                map.putIfAbsent(index, new ArrayList<>());
                map.get(index).add(node.data);

                if (node.left != null) {
                    q.offer(node.left);
                    indices.offer(index - 1);

                    minIndex = Math.min(minIndex, index - 1);
                }

                if (node.right != null) {
                    q.offer(node.right);
                    indices.offer(index + 1);

                    maxIndex = Math.max(maxIndex, index + 1);
                }
            }
        }

        for (int i = minIndex; i <= maxIndex; i++) {
            Collections.sort(map.get(i));
            int size = map.get(i).size();
            List<Integer> levels = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                levels.add(map.get(i).get(j));
            }
            ans.add(levels);
        }

        return ans;
    }

}
