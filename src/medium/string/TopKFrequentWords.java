package medium.string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 */
public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k = 4;

        List<String> res = new TopKFrequentWords().topKFrequent(words, k);
        System.out.println(res.toString());
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : words) {
            if (map.containsKey(s)) {
                map.merge(s, 1, Integer::sum);
            } else {
                map.put(s, 1);
            }
        }

        return map
                .entrySet()
                .stream()
                .sorted((o1, o2) ->
                        o2.getValue() - o1.getValue() == 0
                                ? o1.getKey().compareTo(o2.getKey())
                                : o2.getValue() - o1.getValue())
                .map(Map.Entry::getKey)
                .limit(k)
                .collect(Collectors.toList());
    }
}
