package easy.array;

/**
 * https://leetcode.com/problems/next-greater-element-i/
 * Runtime 35.14% Memory 57.46%
 */
public class NextGreaterElement {

    public static void main(String[] args) {

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        boolean isFind;
        int index;
        for (int i = 0; i < nums1.length; i++) {
            isFind = false;
            index = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (isFind) {
                    if (nums2[j] > nums1[i]) {
                        index = j;
                        break;
                    }
                } else {
                    if (nums1[i] == nums2[j]) {
                        isFind = true;
                    }
                }
            }
            nums1[i] = index == -1 ? index : nums2[index];
        }
        return nums1;
    }
}
