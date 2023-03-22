package easy.tree;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * Runtime 95.2% Memory 49.21%
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(getDepth(root.left) - getDepth(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Integer.max(getDepth(node.left), getDepth(node.right));
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
