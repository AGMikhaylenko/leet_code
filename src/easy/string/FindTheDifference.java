package easy.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-the-difference/
 * Runtime 25.27% Memory 44.39%
 */
public class FindTheDifference {

    public static void main(String[] args) {
        char c = new FindTheDifference().findTheDifference("", "y");
        System.out.println(c);
    }

    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.merge(c, 1, Integer::sum);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return c;
            } else {
                if (map.get(c) == 0) {
                    return c;
                } else {
                    map.merge(c, -1, Integer::sum);
                }
            }
        }

        return 'a';
    }
}
