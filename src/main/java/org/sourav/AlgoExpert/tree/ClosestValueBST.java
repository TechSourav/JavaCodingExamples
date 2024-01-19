package org.sourav.AlgoExpert.tree;

public class ClosestValueBST {

    public static void main(String[] args) {

    }

    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.

        return findClosestValueInBST(tree, target, tree.value);
    }
    public static int findClosestValueInBST(BST tree, int target, int closest) {
        if(Math.abs(target - closest) > Math.abs(target - tree.value)) {
            closest = tree.value;
        }

        if(target > tree.value && tree.right != null) {
            return findClosestValueInBST(tree.right, target, closest);
        } else if (target < tree.value &&  tree.left != null) {
            return findClosestValueInBST(tree.left, target, closest);
        } else {
            return closest;
        }
    }

}
