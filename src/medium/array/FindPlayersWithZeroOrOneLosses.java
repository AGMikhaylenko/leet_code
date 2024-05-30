package medium.array;

import java.util.*;

/**
 * https://leetcode.com/problems/find-players-with-zero-or-one-losses/
 * Runtime 28.33% Memory 6.80%
 */
public class FindPlayersWithZeroOrOneLosses {

    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> all = new HashSet<>();
        for (int[] a : matches) {
            all.add(a[0]);
            all.add(a[1]);
        }

        Set<Integer> lose1 = new HashSet<>();
        Set<Integer> loseMany = new HashSet<>();

        for (int[] a : matches) {
            if (!loseMany.contains(a[1])) {
                if (lose1.contains(a[1])) {
                    lose1.remove(a[1]);
                    loseMany.add(a[1]);
                } else {
                    all.remove(a[1]);
                    lose1.add(a[1]);
                }
            }
        }

        List<Integer> list0 = new ArrayList<>(all);
        list0.sort(Comparator.naturalOrder());

        List<Integer> list1 = new ArrayList<>(lose1);
        list1.sort(Comparator.naturalOrder());

        return List.of(
                list0,
                list1
        );
    }
}
