package easy.array;

public class MaximumProductOfTwoElementsInAnArray {

    public int maxProduct(int[] nums) {
        int preMax = nums[0] < nums[1] ? nums[0] : nums[1];
        int max = nums[0] < nums[1] ? nums[1] : nums[0];

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > preMax) {
                preMax = nums[i];
            }
            if (nums[i] > max) {
                preMax = max;
                max = nums[i];
            }
        }

        return (preMax - 1) * (max - 1);
    }
}
