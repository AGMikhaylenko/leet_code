package medium.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/fruit-into-baskets/
 * Runtime 29.12% Memory 78.10%
 */
public class FruitIntoBaskets {

    public static void main(String[] args) {
        int[] fruits = {1};
        int res = new FruitIntoBaskets().totalFruit(fruits);
        System.out.println(res);
    }

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> uniqueMap = new HashMap<>();

        int start = 0;
        int end = 0;
        uniqueMap.put(fruits[0], 1);

        while (end < fruits.length - 1) {

            if (uniqueMap.size() > 1 && !uniqueMap.containsKey(fruits[end + 1]) || uniqueMap.size() > 2) {
                if (uniqueMap.get(fruits[start]) == 1) {
                    uniqueMap.remove(fruits[start]);
                } else {
                    uniqueMap.merge(fruits[start], -1, Integer::sum);
                }
                start++;
            }

            if (uniqueMap.containsKey(fruits[end + 1])) {
                uniqueMap.merge(fruits[end + 1], 1, Integer::sum);
            } else {
                uniqueMap.put(fruits[end + 1], 1);
            }

            end++;
        }

        return fruits.length - start;
    }
}
