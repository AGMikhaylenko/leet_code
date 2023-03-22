package medium.array;

/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 * Runtime 100% Memory 5.34%
 */
public class SingleElementInASortedArray {

    public static void main(String[] args) {
        int [] nums = {2, 3,3,7,7,10,10};
        System.out.println(new SingleElementInASortedArray().singleNonDuplicate(nums));
    }

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (mid == 0 || mid == n - 1) {
                return nums[mid];
            }
            if (nums[mid - 1] != nums[mid]
                    && nums[mid + 1] != nums[mid]) {
                return nums[mid];
            }

            if (mid % 2 == 0 && nums[mid + 1] != nums[mid]
                    || mid % 2 == 1 && nums[mid + 1] == nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
