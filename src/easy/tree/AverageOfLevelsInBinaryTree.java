package easy.tree;

import easy.tree.nodes.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
 */
public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        Map<Integer, List<Integer>> valByLevel = new HashMap<>();

        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> levels = new Stack<>();

        nodes.push(root);
        levels.push(1);

        while (!nodes.empty()) {
            TreeNode node = nodes.pop();
            Integer level = levels.pop();

            if (valByLevel.containsKey(level)) {
                valByLevel.get(level).add(node.val);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(node.val);
                valByLevel.put(level, l);
            }

            if (node.left != null) {
                nodes.push(node.left);
                levels.push(level + 1);
            }

            if (node.right != null) {
                nodes.push(node.right);
                levels.push(level + 1);
            }
        }

        return valByLevel.values()
                .stream()
                .map(list -> (double)list.stream().mapToLong(x->x).sum()/list.size())
                .collect(Collectors.toList());
    }
}
