package easy.common;

/**
 * https://leetcode.com/problems/thousand-separator/
 * Runtime 100% Memory 70.83%
 */
public class ThousandSeparator {

    public String thousandSeparator(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();

        byte count = 0;
        while (n != 0) {
            sb.append(n % 10);
            count++;
            n /= 10;
            if (count % 3 == 0 && n != 0) {
                sb.append('.');
            }
        }

        return sb.reverse().toString();
    }
}
