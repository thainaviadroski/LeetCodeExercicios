package BinaryTree;

import java.util.*;

public class BinaryTreeResolveLetCode {

    private static Map<Integer, Integer> inorderMap;
    private static int[] postorder;

    static void main() {
        TreeNode<Integer> root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
//
//        List<Integer> result = preorderTraversal(root);
//        System.out.println("Preorder: " + result.toString());
//
//        result = inorderTraversal(root);
//        System.out.println("Inorder: " + result.toString());
//
//        result = posorderTraversal(root);
//        System.out.println("Posorder: " + result.toString());

//        System.out.println("-----------------------------");
//        System.out.println("Build tree traversal");
//        int[] inorder = {9, 3, 15, 20, 7};
//        postorder = new int[]{9, 15, 20, 7, 3};
//
//
//        TreeNode root2 = buildTree(inorder, postorder);
//        System.out.println(root2.toString());
//
//
//        System.out.println("++++++++++++++++++ Path Sum +++++++++++++++++++++++++++++++");
//        System.out.println(hasPathSum(root2, 12));

        System.out.println("Original: " + root.toString());
//        TreeNode<Integer> result = invertTree(root);
//        System.out.println("\nInvertida: " + result.toString());

        bfs(root, 3);

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

//    public static TreeNode buildTree(int[] inorder, int[] postorder) {
//        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
//    }
//
//    private static TreeNode build(int[] inorder, int[] postorder,
//                           int inStart, int inEnd,
//                           int postStart, int postEnd) {
//        if (inStart > inEnd || postStart > postEnd) return null;
//
//
//        int rootVal = postorder[postEnd];
//        TreeNode root = new TreeNode(rootVal);
//
//
//        int inorderIndex = 0;
//        for (int i = inStart; i <= inEnd; i++) {
//            if (inorder[i] == rootVal) {
//                inorderIndex = i;
//                break;
//            }
//        }
//
//        int leftSize = inorderIndex - inStart;
//
//        root.left = build(inorder, postorder,
//                inStart, inorderIndex - 1,
//                postStart, postStart + leftSize - 1);
//
//        root.right = build(inorder, postorder,
//                inorderIndex + 1, inEnd,
//                postStart + leftSize, postEnd - 1);
//
//        return root;
//    }


    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        postorder = postorder;
        inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(0, inorder.length - 1, 0, postorder.length - 1);
    }

    private static TreeNode build(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd) return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int inorderIndex = inorderMap.get(rootVal); // O(1)
        int leftSize = inorderIndex - inStart;

        root.left = build(inStart, inorderIndex - 1, postStart, postStart + leftSize - 1);
        root.right = build(inorderIndex + 1, inEnd, postStart + leftSize, postEnd - 1);

        return root;
    }

    // DFS - Path Sum

    public static boolean hasPathSum(TreeNode<Integer> node, int target) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return target == node.val;
        }
        return hasPathSum(node.left, target - node.val) || hasPathSum(node.right, target - node.val);
    }

    public static TreeNode<Integer> invertTree(TreeNode<Integer> root) {
        if (root == null) return null;

        TreeNode<Integer> temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    // BFS - Breadth First Search


    public static TreeNode<Integer> bfs(TreeNode<Integer> root, int target) {
        if (root == null) return null;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.poll();
            System.out.println(node.val);

            if (node.val == target) return node;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return null;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node = queue.poll();
                if (node != null) {
                    level.add(node.val);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
            }

            if (!level.isEmpty())
                res.add(level);
        }
        return res;
    }
}