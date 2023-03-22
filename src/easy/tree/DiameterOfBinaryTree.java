package easy.tree;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * Runtime 9.10% memory 79.73%
 */
public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Integer.max(
                getDepth(root.left) + getDepth(root.right),
                Integer.max(
                        diameterOfBinaryTree(root.left),
                        diameterOfBinaryTree(root.right)
                )
        );
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
