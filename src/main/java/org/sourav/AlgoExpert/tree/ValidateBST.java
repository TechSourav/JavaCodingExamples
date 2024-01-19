package org.sourav.AlgoExpert.tree;

import java.sql.SQLOutput;

public class ValidateBST {

    public static void main(String[] args) {
        BST root = new BST(20);
        root.left = new BST(10);
        root.right = new BST(40);
        root.left.left = new BST(8);
        root.left.right = new BST(15);
        root.right.left = new BST(30);
        root.right.right = new BST(42);

        if (validateBst(root))
            System.out.println("true");
        else
            System.out.println("False");
    }

    public static boolean validateBst(BST tree) {
        return isValid(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValid(BST tree, int min, int max) {
        if (tree == null) return true;
        if (tree.value < min || tree.value >= max) return false;
        return isValid(tree.left,min, tree.value) && isValid(tree.right,tree.value, max);
    }
}
