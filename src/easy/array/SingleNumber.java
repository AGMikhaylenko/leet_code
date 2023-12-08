package easy.array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/single-number/?envType=study-plan-v2&envId=top-100-liked
 * Runtime  Memory
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i: nums){
            if(set.contains(i)){
                set.remove(i);
            }else{
                set.add(i);
            }
        }

        return set.stream().findFirst().get();
    }
}
