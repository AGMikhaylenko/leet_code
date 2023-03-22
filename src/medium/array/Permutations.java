package medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 * Runtime 5.35% Memory 16.77%
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().toList();
        return getPermute(list);
    }

    private List<List<Integer>> getPermute(List<Integer> list) {
        if (list.size() <= 1) {
            return List.of(list);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (Integer i : list) {
            List<Integer> newList = new ArrayList<>(list.size());
            newList.addAll(list);
            newList.remove(i);
            for (List<Integer> listRes : getPermute(newList)) {
                List<Integer> r = new ArrayList<>();
                r.add(i);
                r.addAll(listRes);
                res.add(r);
            }
        }
        return res;
    }
}
