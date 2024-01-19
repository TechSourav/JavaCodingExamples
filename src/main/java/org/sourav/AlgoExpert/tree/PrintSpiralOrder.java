package org.sourav.AlgoExpert.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintSpiralOrder {

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        spiralOrder(root);
    }

    private static void spiralOrder(final Node root ) {
        if (root == null)
            return;
        final Queue<Node> q1 = new LinkedList<>();
        final Queue<Node> q2 = new LinkedList<>();

        q1.add(root);

        while (!q1.isEmpty() || !q2.isEmpty()) {
            while (!q1.isEmpty()) {
                Node nd1 = q1.poll();
                System.out.println(nd1.data);

                if (nd1 != null && nd1.left != null) {
                    q2.add(nd1.left);
                }
                if (nd1 != null && nd1.right != null) {
                    q2.add(nd1.right);
                }

            }

            while (!q2.isEmpty()) {
                Node nd2 = q2.poll();
                System.out.println(nd2.data);

                if (nd2 != null && nd2.right != null) {
                    q1.add(nd2.right);
                }
                if (nd2 != null && nd2.left != null) {
                    q1.add(nd2.left);
                }
            }
        }
    }

}
