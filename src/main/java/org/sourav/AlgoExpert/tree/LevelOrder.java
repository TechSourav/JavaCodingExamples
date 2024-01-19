package org.sourav.AlgoExpert.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        System.out.println("Height of the tree: " + height(root));
        System.out.println("************************************");
        levelOrder(root);
        System.out.println("************************************");
    }

    public static int height(Node root) {
        if (root == null)
            return 0;
        else {
            /* compute height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    private static void levelOrder(final Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node nd = q.poll();
            System.out.println(nd.data);

            if (nd.left != null)
                q.add(nd.left);
            if (nd.right != null)
                q.add(nd.right);

        }

    }

}
