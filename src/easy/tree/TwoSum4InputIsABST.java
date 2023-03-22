package easy.tree;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 * Runtime 97.85% Memory 24.94%
 */
public class TwoSum4InputIsABST {

    public boolean findTarget(TreeNode root, int k) {
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        TreeNode current;
        while (!queue.isEmpty()) {
            current = queue.remove(0);
            if(current == null){
                continue;
            }

            if (eq(root, current, k- current.val)){
                return true;
            }

            queue.add(current.left);
            queue.add(current.right);
        }

        return false;
    }

    private boolean eq(TreeNode root, TreeNode current, int target) {
        TreeNode c = root;

        while (c != null) {
            if (c.val == target && c != current) {
                return true;
            }

            if (target >= c.val) {
                c = c.right;
            } else {
                c = c.left;
            }
        }

        return false;
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
