package easy.operation_with_numbers;

/**
 * https://leetcode.com/contest/biweekly-contest-98/problems/maximum-difference-by-remapping-a-digit/
 */
public class MaximumDifferenceByRemappingADigit {

    public static void main(String[] args) {
        int n = 999;
        System.out.println(new MaximumDifferenceByRemappingADigit().minMaxDifference(n));
    }

    public int minMaxDifference(int num) {
        int min = 0;
        int max = 0;

        char[] digits = String.valueOf(num).toCharArray();
        char[] buf = new char[digits.length];

        min = digits[0];
        buf[0] = '0';

        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == min) {
                buf[i] = '0';
            } else {
                buf[i] = digits[i];
            }
        }

        min = 0;
        int power = 0;
        for (int i = buf.length - 1; i >= 0; i--) {
            min += Integer.valueOf(String.valueOf(buf[i])) * Math.pow(10, power++);
        }

        int i = 0;
        while (i < digits.length && digits[i] == '9') {
            i++;
        }

        for (int c = 0; c < digits.length; c++) {
            if (c < i) {
                buf[c] = digits[c];
            }
            if (c == i) {
                max = digits[c];
                buf[c] = '9';
            }
            if (c > i) {
                if (digits[c] == max) {
                    buf[c] = '9';
                } else {
                    buf[c] = digits[c];
                }
            }
        }

        max = 0;
        power = 0;
        for (int in = buf.length - 1; in >= 0; in--) {
            max += Integer.valueOf(String.valueOf(buf[in])) * Math.pow(10, power++);
        }

        return max - min;
    }
}
