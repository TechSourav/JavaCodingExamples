package org.sourav.AlgoExpert.tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class PostOrderTraversal {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        // Function call
        System.out.println("Postorder traversal of binary tree is: ");
        //printPostOrder(root);
        postOrderIterative(root);
    }

    /*private static void printPostOrder(final Node root ) {
        if (root == null)
            return;

        printPostOrder(root.left);

        printPostOrder(root.right);

        System.out.println(root.data);
    }*/

    // WITHOUT RECURSION....

    private static void printPostOrder(final Node root ) {
        Stack<Node> st = new Stack<>();
        Set<Integer> set = new HashSet<>();

        if (root == null) {
            return;
        }

        st.push(root);

        while (!st.isEmpty()) {
            Node nd = st.peek();
            set.add(nd.data);
            if (nd.right != null && !set.contains(nd.right.data)) {
                st.push(nd.right);
            }

            if (nd.left != null && !set.contains(nd.left.data)) {
                st.push(nd.left);
            }
            if ((nd.left == null && nd.right == null)
                    || ((nd.left != null && set.contains(nd.left.data))
                            || ( nd.right != null && set.contains(nd.right.data)))) {
                System.out.print(nd.data + " ");
                // remove node
                st.pop();
            }
        }
    }

    /*
     * Push directly root node two times while traversing to the left. While popping if you find stack top()
     * is same as root then go for root->right else print root.
     */
    private static void postOrderIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        while(true) {
            while(root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }

            // Check for empty stack
            if(stack.empty())
                return;
            root = stack.pop();

            if(!stack.empty() && stack.peek() == root)
                root = root.right;

            else {

                System.out.print(root.data + " "); root = null;
            }
        }
    }

    // can be done using 2 stacks...

}
