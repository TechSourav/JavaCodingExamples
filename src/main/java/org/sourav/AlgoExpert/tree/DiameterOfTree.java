package org.sourav.AlgoExpert.tree;

public class DiameterOfTree {

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        System.out.println("Diameter of the tree: " + diameter(root));
        System.out.println("************************************");
    }

    private static int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        int lHeight = LevelOrder.height(root.left);
        int rHeight = LevelOrder.height(root.right);

        int lDiameter = diameter(root.left);
        int rDiameter = diameter(root.right);

        return Math.max((lHeight + rHeight + 1), Math.max(lDiameter, rDiameter));

    }

}
