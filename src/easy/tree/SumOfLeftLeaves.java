package easy.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 * Runtime 12.29% Memory 61.78%
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;

        List<TreeNode> stack = new ArrayList<>();
        stack.add(root);

        TreeNode current;
        while (!stack.isEmpty()) {
            current = stack.remove(stack.size() - 1);
            if (current.left != null) {
                stack.add(current.left);
                if(current.left.left == null && current.left.right == null){
                    sum += current.left.val;
                }
            }
            if (current.right != null) {
                stack.add(current.right);
            }
        }

        return sum;
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
