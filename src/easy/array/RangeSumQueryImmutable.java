package easy.array;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 * Runtime 24.30% Memory 27.52%
 */
public class RangeSumQueryImmutable {

    class NumArray {

        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += this.nums[i];
            }
            return sum;
        }
    }
}
