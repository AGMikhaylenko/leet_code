package medium.operations_with_numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/monotone-increasing-digits/
 * Runtime 81.85% Memory 78.52%
 */
public class MonotoneIncreasingDigits {

    public static void main(String[] args) {
        int n = new MonotoneIncreasingDigits().monotoneIncreasingDigits(154);
        System.out.println(n);
    }

    public int monotoneIncreasingDigits(int n) {
        List<Integer> digits = new ArrayList<>();
        int res = n;
        while (n != 0) {
            digits.add(n % 10);
            n /= 10;
        }

        int first = -1;
        for (int i = digits.size() - 1; i > 0; i--) {
            if (digits.get(i) > digits.get(i - 1)) {
                first = i;
                break;
            }
        }
        if (first == -1) {
            return res;
        }

        int i = first;
        do {
            if (digits.get(i) != 0 && (i == digits.size() - 1 || digits.get(i + 1) < digits.get(i))) {
                digits.set(i, digits.get(i) - 1);
                break;
            } else {
                digits.set(i, 9);
            }
            i++;
        } while (true);

        for (i = 0; i < digits.size(); i++) {
            if (i < first) {
                n += 9 * Math.pow(10, i);
            } else {
                n += digits.get(i) * Math.pow(10, i);
            }
        }

        return n;
    }
}
