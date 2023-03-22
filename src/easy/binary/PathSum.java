package easy.binary;

/**
 * https://leetcode.com/problems/path-sum/
 * Runtime 100% Memory 16.85%
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        return hasPathSumRecursion(root, targetSum);
    }

    public boolean hasPathSumRecursion(TreeNode root, int targetSum) {
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        boolean lResult = false;
        boolean rResult = false;
        if (root.left != null) {
            lResult = hasPathSumRecursion(root.left, targetSum - root.val);
        }
        if (root.right != null) {
            rResult = hasPathSumRecursion(root.right, targetSum - root.val);
        }
        return lResult || rResult;
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
