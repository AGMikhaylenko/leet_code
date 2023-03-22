package easy.operation_with_numbers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Easy
 * https://leetcode.com/problems/two-sum
 * Runtime 70.83%, Memory 60.38%
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        int[] res = new TwoSum().twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexByValueMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexByValueMap.put(nums[i], i);
        }

        int value;
        Integer indexB;
        for (int i = 0; i < nums.length; i++) {
            value = target - nums[i];
            indexB = indexByValueMap.get(value);
            if (indexB != null && indexB != i) {
                return new int[]{i, indexB};
            }
        }

        return new int[]{};
    }
}
