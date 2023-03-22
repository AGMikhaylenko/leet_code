package easy.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/
 * Runtime 68.57% Memory 48.24%
 */
public class CheckIfOneStringSwapCanMakeStringsEqual {

    public boolean areAlmostEqual(String s1, String s2) {
        char[] symbols1 = s1.toCharArray();
        char[] symbols2 = s2.toCharArray();

        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < symbols1.length; i++) {
            if (symbols1[i] != symbols2[i]) {
                indexes.add(i);
            }
        }

        return indexes.isEmpty()
                || indexes.size() == 2
                && symbols1[indexes.get(0)] == symbols2[indexes.get(1)]
                && symbols1[indexes.get(1)] == symbols2[indexes.get(0)];
    }
}
