package org.sourav.AlgoExpert.tree;

import java.util.Stack;

public class PreeOrderTraversal {

    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.right.right = new Node(9);

        // Function call
        System.out.println("Postorder traversal of binary tree is: ");
        printPreOrder(root);
    }

    /*private static void printPreOrder(final Node root ) {
        if (root == null)
            return;

        System.out.println(root.data);

        printPreOrder(root.left);

        printPreOrder(root.right);

    }*/

    // WITHOUT RECURSION....

    private static void printPreOrder(final Node root ) {
        Stack<Node> st = new Stack<>();
         if (root == null) {
             return;
         }
         st.push(root);
         while (!st.isEmpty()) {
             Node nd = st.pop();
             System.out.print(nd.data + " ");

             if (nd.right != null) {
                 st.push(nd.right);
             }
             if (nd.left != null) {
                 st.push(nd.left);
             }
         }
    }

}
