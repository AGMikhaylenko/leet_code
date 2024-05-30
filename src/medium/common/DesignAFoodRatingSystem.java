package medium.common;

import java.util.*;

/**
 * https://leetcode.com/problems/design-a-food-rating-system/
 */
public class DesignAFoodRatingSystem {

    Map<String, String> cuisineMap = new HashMap<>();
    Map<String, PriorityQueue<Food>> foodMap = new HashMap<>();

    public DesignAFoodRatingSystem(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            cuisineMap.put(foods[i], cuisines[i]);

            if (!foodMap.containsKey(cuisines[i])) {
                foodMap.put(cuisines[i], new PriorityQueue<>());
            }
            foodMap.get(cuisines[i]).add(new Food(foods[i], ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        PriorityQueue<Food> foods = foodMap.get(cuisineMap.get(food));

        Food fo = foods.stream()
                .filter(f -> f.name.equals(food))
                .findFirst()
                .get();

        foods.remove(fo);
        fo.rating = newRating;
        foods.add(fo);
    }

    public String highestRated(String cuisine) {
        return foodMap.get(cuisine).peek().name;
    }

    static class Food implements Comparable<Food> {
        String name;
        int rating;

        public Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }

        @Override
        public int compareTo(Food o) {
            int res = Integer.compare(this.rating, o.rating);
            return res != 0
                    ? res
                    : -1 * this.name.compareTo(o.name);
        }
    }
}
