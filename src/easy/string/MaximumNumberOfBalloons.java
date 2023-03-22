package easy.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-number-of-balloons/
 * Runtime 56.35% Memory 26.12%
 */
public class MaximumNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> symbolsMap = new HashMap<>();
        symbolsMap.put('b', 0);
        symbolsMap.put('a', 0);
        symbolsMap.put('l', 0);
        symbolsMap.put('o', 0);
        symbolsMap.put('n', 0);

        for (char c : text.toCharArray()) {
            if (c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n') {
                symbolsMap.merge(c, 1, Integer::sum);
            }
        }

        return Integer.min(
                Integer.min(
                        symbolsMap.get('b'),
                        symbolsMap.get('a')
                ),
                Integer.min(
                        Integer.min(
                                symbolsMap.get('l') / 2,
                                symbolsMap.get('o') / 2
                        ),
                        symbolsMap.get('n')
                )
        );
    }
}
