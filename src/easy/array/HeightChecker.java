package easy.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/height-checker/
 * Runtime 87.73% Memory 11.61%
 */
public class HeightChecker {

    public int heightChecker(int[] heights) {
        int[] e = Arrays.copyOf(heights, heights.length);
        Arrays.sort(e);

        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (e[i] != heights[i]) {
                res++;
            }
        }

        return res;
    }
}
