package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    static void main() {
        TreeNode<Integer> root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        List<Integer> result = preorderTraversal(root);
        System.out.println("Preorder: " + result.toString());

        result = inorderTraversal(root);
        System.out.println("Inorder: " + result.toString());

        result = posorderTraversal(root);
        System.out.println("Posorder: " + result.toString());
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private static void inorder(TreeNode<Integer> root, List<Integer> result) {
        if (root == null) return;
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }


    public static List<Integer> preorderTraversal(TreeNode data) {
        List<Integer> result = new ArrayList<>();
        preorder(data, result);
        return result;
    }

    private static void preorder(TreeNode<Integer> root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    public static List<Integer> posorderTraversal(TreeNode data) {
        List<Integer> result = new ArrayList<>();
        posorder(data, result);
        return result;
    }

    private static void posorder(TreeNode<Integer> root, List<Integer> result) {
        if (root == null) return;
        posorder(root.left, result);
        posorder(root.right, result);
        result.add(root.val);
    }

}
