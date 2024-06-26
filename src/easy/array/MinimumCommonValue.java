package easy.array;

/**
 * https://leetcode.com/problems/minimum-common-value/
 * Runtime 81.47% Memory 95.55%
 */
public class MinimumCommonValue {

    public int getCommon(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                return nums1[index1];
            }

            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }

        return -1;
    }
}
