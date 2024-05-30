package easy.string;

/**
 * https://leetcode.com/problems/maximum-odd-binary-number/
 * Runtime 83.47% Memory 96.48%
 */
public class MaximumOddBinaryNumber {

    public String maximumOddBinaryNumber(String s) {
        int count1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count1++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append('1');

        sb.append("0".repeat(Math.max(0, s.length() - count1)));
        count1--;
        sb.append("1".repeat(Math.max(0, count1)));

        return sb.reverse().toString();
    }
}
