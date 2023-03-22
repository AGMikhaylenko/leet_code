package easy.array;

/**
 * https://leetcode.com/problems/sign-of-the-product-of-an-array/
 * Runtime 100% Memory 88.48%
 */
public class SignOfTheProductOfAnArray {

    public int arraySign(int[] nums) {
        short negativeCount = 0;

        for (int i : nums) {
            if (i == 0) {
                return 0;
            }
            if (i < 0) {
                negativeCount++;
            }
        }

        return negativeCount % 2 == 0 ? 1 : -1;
    }
}
