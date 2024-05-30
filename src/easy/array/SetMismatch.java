package easy.array;

/**
 * https://leetcode.com/problems/set-mismatch
 * Runtime 100% Memory 52.4%
 */
public class SetMismatch {

    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        boolean[] exists = new boolean[nums.length];

        for (int i : nums) {
            if (exists[i - 1]) {
                res[0] = i;
            } else {
                exists[i - 1] = true;
            }
        }

        for (int i = 0; i < exists.length; i++) {
            if (!exists[i]) {
                res[1] = i + 1;
                return res;
            }
        }

        return res;
    }
}
