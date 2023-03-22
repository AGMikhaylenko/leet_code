package medium.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/group-anagrams/
 * Runtime 7.80% Memory 16.67%
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<Extra> extra = new LinkedList<>();
        for (String s : strs) {
            extra.add(new Extra(s));
        }

        return extra
                .stream()
                .collect(
                        Collectors.groupingBy(Extra::getMap)
                )
                .values()
                .stream()
                .map(
                        list -> list.stream()
                                .map(Extra::getS)
                                .toList()
                )
                .toList();
    }

    class Extra {
        private final String s;
        private final Map<Character, Integer> map;

        public Extra(String s) {
            this.s = s;
            this.map = new HashMap<>();
            fillMap();
        }

        private void fillMap() {
            for (char c : s.toCharArray()) {
                if (map.containsKey(c)) {
                    map.merge(c, 1, Integer::sum);
                } else {
                    map.put(c, 1);
                }
            }
        }

        public String getS() {
            return s;
        }

        public Map<Character, Integer> getMap() {
            return map;
        }
    }
}
