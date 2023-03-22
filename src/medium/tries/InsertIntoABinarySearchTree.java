package medium.tries;

/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 * Runtime 100% Memory 43.21%
 */
public class InsertIntoABinarySearchTree {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode current = root;
        while (true) {
            if (val > current.val) {
                if (current.right == null) {
                    current.right = new TreeNode(val);
                    break;
                } else {
                    current = current.right;
                }
            } else {
                if (current.left == null) {
                    current.left = new TreeNode(val);
                    break;
                } else {
                    current = current.left;
                }
            }
        }

        return root;
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
