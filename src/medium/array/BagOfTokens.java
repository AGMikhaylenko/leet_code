package medium.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/bag-of-tokens/
 * Runtime 37.26% Memory 92.99%
 */
public class BagOfTokens {

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int left = 0;
        int right = tokens.length - 1;

        int score = 0;
        int max = 0;

        while (left <= right) {
            if (score == 0 || tokens[left] <= power) {
                power -= tokens[left];
                score++;
                left++;
                if (power < 0) {
                    return max;
                }
            } else {
                power += tokens[right];
                score--;
                right--;
            }

            max = Math.max(max, score);
        }

        return max;
    }
}
