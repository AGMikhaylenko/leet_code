package easy.array;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 * Runtime 100% Memory 6.7%
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        new MergeSortedArray().merge(nums1, m, nums2, n);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];

        short i1 = 0, i2 = 0;

        for (short i = 0; i < m + n; i++) {
            if (i2 == n || nums1[i1] <= nums2[i2] && i1 < m) {
                res[i] = nums1[i1];
                i1++;
            } else {
                res[i] = nums2[i2];
                i2++;
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = res[i];
        }
    }
}
