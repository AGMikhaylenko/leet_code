package easy.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * Runtime 10.50% Memory 5.95%
 */
public class IntersectionOfTwoArrays2 {

    int left;
    int right;
    int mid;

    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list2 = new ArrayList<>(IntStream.of(nums2).boxed().toList());
        list2.sort(Comparator.naturalOrder());

        List<Integer> res = new ArrayList<>();
        int r;
        for (int i : nums1) {
            r = searchIndex(list2, i);
            if (r != -1) {
                res.add(i);
                list2.remove(r);
            }
        }

        int[] resA = new int[res.size()];
        for (int i = 0; i < resA.length; i++) {
            resA[i] = res.get(i);
        }
        return resA;
    }

    private int searchIndex(ArrayList<Integer> list, int value) {
        left = 0;
        right = list.size() - 1;

        while (left <= right) {
            mid = (left + right) / 2;
            if (list.get(mid) == value) {
                return mid;
            }
            if (list.get(mid) < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
