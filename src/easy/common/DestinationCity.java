package easy.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/destination-city/
 */
public class DestinationCity {

    public String destCity(List<List<String>> paths) {

        final Set<String> cityOne = new HashSet<>();
        final Set<String> cityTwo = new HashSet<>();

        paths.stream()
                .map(ArrayList::new)
                .forEach(list -> {
                    cityOne.add(list.get(0));
                    cityTwo.add(list.get(1));
                });

        return cityTwo.stream()
                .filter(el -> !cityOne.contains(el))
                .findFirst()
                .get();
    }
}
