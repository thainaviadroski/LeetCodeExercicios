package BinaryTree;

public class BinaryTreeTest {
    static void main() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        Integer[] valuesToInsert = {10, 5, 15, 3, 7, 12, 18};

        for (Integer val : valuesToInsert) {
            tree.insert(val);
        }

        TreeNode<Integer> result1 = tree.search(7);
       // TreeNode<Integer> result2 = tree.search(14);
        TreeNode<Integer> result3 = tree.search(10);
        TreeNode<Integer> result4 = tree.search(18);

        System.out.println(result1 != null ? "Encontrado: " + result1.val : "Não encontrado");
//        System.out.println(result2 != null ? "Encontrado: " + result2.val : "Não encontrado");
        System.out.println(result3 != null ? "Encontrado: " + result3.val : "Não encontrado");
        System.out.println(result4 != null ? "Encontrado: " + result4.val : "Não encontrado");
    }
}
