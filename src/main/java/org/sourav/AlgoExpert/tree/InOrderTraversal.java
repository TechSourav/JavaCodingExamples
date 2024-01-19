package org.sourav.AlgoExpert.tree;

import java.util.Stack;

public class InOrderTraversal {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        // Function call
        System.out.println("Postorder traversal of binary tree is: ");
        //printInorder(root);
        printInorderIterative(root);
    }

    /*private static void printInorder(final Node root ) {
        if (root == null)
            return;

        printInorder(root.left);

        System.out.println(root.data);

        printInorder(root.right);

    }*/

    private static void printInorderIterative(final Node root ) {
        Stack<Node> st = new Stack<>();
        Node curr = root;

        while (curr != null || !st.empty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            System.out.println(curr.data);
            curr = curr.right;
        }

    }
}
