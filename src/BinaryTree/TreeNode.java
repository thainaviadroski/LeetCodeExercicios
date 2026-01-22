package BinaryTree;

import LinkedLists.Node;

public class TreeNode<T extends Comparable<T>> {
    public T val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
