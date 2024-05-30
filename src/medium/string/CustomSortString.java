package medium.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/custom-sort-string/
 * Runtime 6.75% Memory 10.87%
 */
public class CustomSortString {

    public String customSortString(String order, String s) {
        char[] orderS = order.toCharArray();
        char[] resS = s.toCharArray();

        Map<Character, Integer> orderMap = new HashMap<>();

        for (int i = 0; i < orderS.length; i++) {
            orderMap.put(orderS[i], i);
        }

        List<CustomLetter> letterList = new LinkedList<>();
        for(char c: resS){
            if(orderMap.containsKey(c)){
                letterList.add(new CustomLetter(c, orderMap.get(c)));
            }else{
                letterList.add(new CustomLetter(c, Integer.MAX_VALUE));
            }
        }

        return letterList.stream()
                .sorted()
                .map(CustomLetter::getCharacter)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private static class CustomLetter implements Comparable<CustomLetter>{
        private final Character character;
        private final Integer order;

        public CustomLetter(Character character, Integer order) {
            this.character = character;
            this.order = order;
        }

        public Character getCharacter() {
            return character;
        }

        public Integer getOrder() {
            return order;
        }

        @Override
        public int compareTo(CustomLetter o) {
            return order.compareTo(o.order);
        }
    }
}
