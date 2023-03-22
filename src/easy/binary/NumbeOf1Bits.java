package easy.binary;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 * Runtime 37.38%, Memory 89.29%
 */
public class NumbeOf1Bits {

    public int hammingWeight(int n) {
        char[] biDigits = Integer.toBinaryString(n).toCharArray();
        int res = 0;

        for (char c : biDigits) {
            if (c == '1') {
                res++;
            }
        }

        return res;
    }
}
