package org.sourav.Leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<Integer>(2);
        root.left.left = new TreeNode<Integer>(3);
        root.right = new TreeNode<Integer>(4);
        root.right.left = new TreeNode<Integer>(5);
        root.right.right = new TreeNode<Integer>(6);

        System.out.println(levelOrder(root));
    }

    private static List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        final Queue<TreeNode<Integer>> q = new LinkedList<>();
        final List<List<Integer>> finalList = new ArrayList<>();
        if (root == null) {
            return finalList;
        }
        q.offer(root);

        while (!q.isEmpty()) {
            int len = q.size();

            final List<Integer> currLst = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                final TreeNode<Integer> curr = q.poll();
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
                currLst.add(curr.data);
            }
            finalList.add(currLst);
        }

        return finalList;

        /*while(!q.isEmpty()){
            int levels = q.size();
            List<Integer> subLevels = new ArrayList<>();
            for(int i=0;i<levels;i++){
                if(q.peek().left!=null){
                    q.add(q.peek().left);
                }
                if(q.peek().right!=null){
                    q.add(q.peek().right);
                }
                subLevels.add(q.remove().data);
            }
            finalList.add(subLevels);
        }
        return finalList;*/
    }

}
