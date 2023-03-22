package easy.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy
 * https://leetcode.com/problems/binary-tree-postorder-traversal
 */
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        if (root == null) {
            return values;
        }

        postorder(root, values);

        return values;
    }

    private void postorder(TreeNode root, List<Integer> values) {
        if (root.left != null) {
            postorder(root.left, values);
        }
        if (root.right != null) {
            postorder(root.right, values);
        }
        values.add(root.val);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
