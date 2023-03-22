package easy.binary;

/**
 * https://leetcode.com/problems/binary-number-with-alternating-bits
 * Runtime 100%, Memory 71.63%
 */
public class BinaryNumberWithAlternatingBits {

    public static void main(String[] args) {
        var res = new BinaryNumberWithAlternatingBits().hasAlternatingBits(11);
        System.out.println(res);
    }

    public boolean hasAlternatingBits(int n) {
        char[] biDigits = Integer.toBinaryString(n).toCharArray();

        for (int i = 0; i < biDigits.length - 1; i++) {
            if (biDigits[i] == biDigits[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
