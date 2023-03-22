package medium.tries;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/
 * Runtime 5.99% Memory 95.61%
 */
public class ReverseOddLevelsOfBinaryTree {

    public TreeNode reverseOddLevels(TreeNode root) {
        List<TreeNodeExtra> queue = new ArrayList<>();
        queue.add(new TreeNodeExtra(root, 0));
        List<List<TreeNode>> nodesByLevels = new ArrayList<>();

        TreeNodeExtra currentExtra;
        int index;
        while (!queue.isEmpty()) {
            currentExtra = queue.remove(0);

            if (currentExtra.level % 2 == 1) {
                index = currentExtra.level / 2;
                if (nodesByLevels.size() < index + 1) {
                    nodesByLevels.add(new ArrayList<>());
                }
                nodesByLevels.get(index).add(currentExtra.node);
            }

            if (currentExtra.node.left != null) {
                queue.add(new TreeNodeExtra(currentExtra.node.left, currentExtra.level + 1));
            }

            if (currentExtra.node.right != null) {
                queue.add(new TreeNodeExtra(currentExtra.node.right, currentExtra.level + 1));
            }
        }

        for (List<TreeNode> level : nodesByLevels) {
            for (int i = 0; i < level.size() / 2; i++) {
                index = level.get(i).val;
                level.get(i).val = level.get(level.size() - 1 - i).val;
                level.get(level.size() - 1 - i).val = index;
            }
        }

        return root;
    }

    class TreeNodeExtra {
        int level;
        TreeNode node;

        public TreeNodeExtra(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
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
