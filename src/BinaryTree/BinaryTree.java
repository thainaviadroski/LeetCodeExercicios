package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(T element) {
        if (this.root == null) {
            this.root = new TreeNode<>(element);
        } else {
            insertRecursive(this.root, element);
        }
    }

    private void insertRecursive(TreeNode<T> node, T element) {
        if (element.compareTo(node.val) < 0) {
            if (node.left != null) {
                insertRecursive(node.left, element);
            } else {
                node.left = new TreeNode<>(element);
            }
        } else {
            if (node.right != null) {
                insertRecursive(node.right, element);
            } else {
                node.right = new TreeNode<>(element);
            }
        }
    }

    public TreeNode<T> search(T element) {
        return searchRecursive(this.root, element);
    }

    private TreeNode<T> searchRecursive(TreeNode<T> node, T element) {
        if (node == null) {
            throw new IllegalArgumentException("Arvoce vazia");
        }
        if (node.val.equals(element)) {
            return node;
        }
        if (element.compareTo(node.val) < 0) {
            return searchRecursive(node.left, element);
        }
        return searchRecursive(node.right, element);
    }

    public boolean dfs(T element) {
        return dfsRecursive(this.root, element);
    }

    private boolean dfsRecursive(TreeNode<T> node, T element) {
        if (node == null) {
            return false;
        }
        System.out.println(node.val);
        if (node.val.equals(element)) {
            return true;
        }
        if (dfsRecursive(node.left, element)) {
            return true;
        }
        if (dfsRecursive(node.right, element)) {
            return true;
        }
        return false;
    }

    public List<T> preorderTraversal(BinaryTree<T> data) {
        List<T> result = new ArrayList<>();
        preorder(data.root, result);
        return result;
    }

    private void preorder(TreeNode<T> root, List<T> result) {
        if (root == null) return;
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    public List<T> inorderTraversal(BinaryTree<T> data) {
        List<T> result = new ArrayList<>();
        inorder(data.root, result);
        return result;
    }

    private void inorder(TreeNode<T> root, List<T> result) {
        if (root == null) return;
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    public List<T> posorderTraversal(BinaryTree<T> data) {
        List<T> result = new ArrayList<>();
        posorder(data.root, result);
        return result;
    }

    private void posorder(TreeNode<T> root, List<T> result) {
        if (root == null) return;
        posorder(root.left, result);
        posorder(root.right, result);
        result.add(root.val);
    }

    @Override
    public String toString() {
        if (root == null) return "(árvore vazia)";

        StringBuilder sb = new StringBuilder();
        buildString(root, sb, "", "");
        return sb.toString();
    }


    private void buildString(TreeNode<T> node, StringBuilder sb,
                             String prefix, String childPrefix) {
        if (node == null) return;

        sb.append(prefix).append("[ ").append(node.val).append(" ]\n");

        if (node.left != null || node.right != null) {
            // filho direito primeiro (fica "em cima" visualmente)
            buildString(node.right, sb,
                    childPrefix + "├── (D) ",
                    childPrefix + "│   ");

            buildString(node.left, sb,
                    childPrefix + "└── (E) ",
                    childPrefix + "    ");
        }
    }
}
