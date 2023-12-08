package medium.array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-unique-binary-string/
 * Runtime 28.36% Memory 29.45%
 */
public class FindUniqueBinaryString {

    public String findDifferentBinaryString(String[] nums) {
        int length = nums[0].length();

        Set<Integer> numbers = new HashSet<>();
        for (String s : nums) {
            numbers.add(Integer.parseInt(s, 2));
        }

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (!numbers.contains(i)) {
                String answer = Integer.toBinaryString(i);
                while(answer.length() < length){
                    answer = String.format("0%s", answer);
                }
                return answer;
            }
        }

        return null;
    }
}
