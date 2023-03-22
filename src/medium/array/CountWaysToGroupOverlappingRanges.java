package medium.array;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/contest/biweekly-contest-99/problems/count-ways-to-group-overlapping-ranges/
 */
public class CountWaysToGroupOverlappingRanges {

    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, Comparator.comparingInt(o -> o[0]));
        int count = 0;

        for (int i = 0; i < ranges.length; i++) {
            if (i == ranges.length - 1) {
                count++;
                continue;
            }

            if (ranges[i][1] >= ranges[i + 1][0] && ranges[i][0] <= ranges[i + 1][1]) {
                ranges[i + 1][0] = Integer.min(ranges[i][0], ranges[i + 1][0]);
                ranges[i + 1][1] = Integer.max(ranges[i][1], ranges[i + 1][1]);
            } else {
                count++;
            }
        }

        BigInteger bigInteger = BigInteger.valueOf(2);
        bigInteger = bigInteger.pow(count);
        if (bigInteger.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            return bigInteger.mod(BigInteger.valueOf((long) Math.pow(10, 9) + 7)).intValue();
        } else {
            return bigInteger.intValue();
        }
    }
}
