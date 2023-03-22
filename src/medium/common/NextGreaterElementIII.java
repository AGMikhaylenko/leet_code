package medium.common;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-greater-element-iii/
 * Runtime 100% Memory 57.58%
 */
public class NextGreaterElementIII {

    public static void main(String[] args) {
        int n = 2147483476;
        new NextGreaterElementIII().nextGreaterElement(n);
    }

    public int nextGreaterElement(int n) {
        byte[] digits = new byte[String.valueOf(n).length()];
        byte i = 0;
        while (n != 0) {
            digits[digits.length - 1 - i] = (byte) (n % 10);
            n /= 10;
            i++;
        }

        byte goalIndex;
        byte goal;
        for (i = (byte) (digits.length - 1); i >= 0; i--) {
            goal = Byte.MAX_VALUE;
            goalIndex = i;
            for (byte j = (byte) (i + 1); j < digits.length; j++) {
                if (digits[j] > digits[i] && digits[j] < goal) {
                    goal = digits[j];
                    goalIndex = j;
                }
            }
            if (goalIndex != i) {
                goal = digits[i];
                digits[i] = digits[goalIndex];
                digits[goalIndex] = goal;
                break;
            }
        }

        if (i == -1) {
            return -1;
        }

        Arrays.sort(digits, i + 1, digits.length);

        long res = 0;
        for (i = 0; i < digits.length; i++) {
            res += digits[digits.length - 1 - i] * Math.pow(10, i);
        }

        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }
}
