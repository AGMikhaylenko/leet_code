package easy.array;

import java.util.*;

public class FindTheDifferenceOfTwoArrays {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> setOne = new HashSet<>();
        Set<Integer> setTwo = new HashSet<>();

        for(int i: nums1){
            setOne.add(i);
        }

        for(int i: nums2){
            setTwo.add(i);
        }

        List<Integer> cross = new LinkedList<>();
        for(int i: setOne){
            if(setTwo.remove(i)){
                cross.add(i);
            }
        }

        setOne.removeAll(cross);

        return List.of(
                new ArrayList<>(setOne),
                new ArrayList<> (setTwo)
        );
    }
}
