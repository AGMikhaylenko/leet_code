package easy.array;

import java.util.*;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * Runtime 32.21% Memory 61.49%
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index1 = 0;
        int index2 = 0;

        Set<Integer> set = new HashSet<>();
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                set.add(nums1[index1]);
            }

            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }

        List<Integer> list = new ArrayList<>(set);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
