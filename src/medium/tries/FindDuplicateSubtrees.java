package medium.tries;

import java.util.*;

/**
 * https://leetcode.com/problems/find-duplicate-subtrees/
 * Runtime
 */
public class FindDuplicateSubtrees {

    private Map<Integer, Map<Integer, ArrayList<TreeNode>>> map;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        this.map = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();

        level(root);

        for (Map<Integer, ArrayList<TreeNode>> mapByLevel : map.values()) {
            for (List<TreeNode> list : mapByLevel.values()) {
                if (list.size() > 1) {
                    Set<Integer> usedValues = new HashSet<>();
                    for (int i = 0; i < list.size() - 1; i++) {
                        for (int j = i + 1; j < list.size(); j++) {
                            if (!usedValues.contains(list.get(i).val) && !usedValues.contains(list.get(j).val)
                                    && equals(list.get(i), list.get(j))) {
                                res.add(list.get(i));
                                usedValues.add(list.get(i).val);
                                usedValues.add(list.get(j).val);
                                break;
                            }
                        }
                    }
                }
            }
        }

        return res;
    }

    private int level(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int level = 1 + Integer.max(
                level(node.left),
                level(node.right)
        );

        putInMap(node, level);

        return level;
    }

    private void putInMap(TreeNode node, int level) {
        if (map.containsKey(level)) {
            Map<Integer, ArrayList<TreeNode>> mapByLevel = map.get(level);
            if (mapByLevel.containsKey(node.val)) {
                List<TreeNode> list = mapByLevel.get(node.val);
                list.add(node);
            } else {
                ArrayList<TreeNode> list = new ArrayList<>(1);
                list.add(node);
                mapByLevel.put(node.val, list);
            }
        } else {
            ArrayList<TreeNode> list = new ArrayList<>(1);
            list.add(node);
            Map<Integer, ArrayList<TreeNode>> mapForLevel = new HashMap<>();
            mapForLevel.put(node.val, list);
            map.put(level, mapForLevel);
        }
    }

    private boolean equals(TreeNode node1, TreeNode node2) {
        return node1 == null && node2 == null
                || node1 != null && node2 != null
                && node1.val == node2.val
                && equals(node1.left, node2.left)
                && equals(node1.right, node2.right);
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
