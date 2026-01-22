package BinaryTree;

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
}
