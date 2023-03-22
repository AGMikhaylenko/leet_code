package easy.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 * Runtime 9.52% Memory 58.93%
 */
public class MinimumDistanceBetweenBSTNodes {

    public int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE;

        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        List<Integer> values = new ArrayList<>();

        TreeNode current;

        while (!queue.isEmpty()) {
            current = queue.remove(0);
            values.add(current.val);

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        values.sort(Comparator.naturalOrder());

        for (int i = 0; i < values.size() - 1; i++) {
            min = Integer.min(min, values.get(i + 1) - values.get(i));
        }

        return min;
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
