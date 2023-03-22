package medium.graphs;

import java.util.*;

/**
 * https://leetcode.com/problems/shortest-path-with-alternating-colors/
 * Cheater
 * Runtime 27.40% Memory 57.76%
 */
public class ShortestPathWithAlternatingColors {

    public static void main(String[] args) {
        int n = 6;
        int[][] redEdges = {{4, 1}, {3, 5}, {5, 2}, {1, 4}, {4, 2}, {0, 0}, {2, 0}, {1, 1}};
        int[][] blueEdges = {{5, 5}, {5, 0}, {4, 4}, {0, 3}, {1, 0}};

        int[] res = new ShortestPathWithAlternatingColors().shortestAlternatingPaths(n, redEdges, blueEdges);
        System.out.println(Arrays.toString(res));
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<List<Integer>>> map = prepareMap(redEdges, blueEdges);

        int[] res = new int[n];
        Arrays.fill(res, -1);


        boolean[][] vCheck = new boolean[n][2];
        List<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0, -1});
        res[0] = 0;
        vCheck[0][1] = vCheck[0][0] = true;

        int node;
        int step;
        int prevColor;

        while (!queue.isEmpty()) {
            int[] currentNode = queue.remove(0);
            node = currentNode[0];
            step = currentNode[1];
            prevColor = currentNode[2];

            if (!map.containsKey(node)) {
                continue;
            }

            for (List<Integer> nod : map.get(node)) {
                int neighbour = nod.get(0);
                int currentColor = nod.get(1);
                if (prevColor != nod.get(1) && !vCheck[neighbour][currentColor]) {
                    if (res[neighbour] == -1)
                        res[neighbour] = 1 + step;
                    vCheck[neighbour][currentColor] = true;
                    queue.add(new int[]{neighbour, 1 + step, currentColor});
                }
            }
        }
        return res;
    }

    private Map<Integer, List<List<Integer>>> prepareMap(int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int[] link : redEdges) {
            map.computeIfAbsent(link[0], k -> new ArrayList()).add(
                    Arrays.asList(link[1], 0));
        }

        for (int[] link : blueEdges) {
            map.computeIfAbsent(link[0], k -> new ArrayList()).add(
                    Arrays.asList(link[1], 1));
        }
        return map;
    }

}
