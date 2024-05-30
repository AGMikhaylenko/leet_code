package medium.operations_with_numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sequential-digits/
 * Runtime 100% Memory 6.81%
 */
public class SequentialDigits {

    public List<Integer> sequentialDigits(int low, int high) {

        int firstDigit;
        int size;
        int maxSize;
        List<Integer> res = new ArrayList<>();

        String s = String.valueOf(low);
        firstDigit = Integer.parseInt(String.valueOf(s.charAt(0)));
        size = s.length();
        maxSize = String.valueOf(high).length();

        while (true) {
            if (firstDigit + size <= 10) {
                int b = createInt(firstDigit, size);
                if (size == maxSize && b > high) {
                    return res;
                }

                if (b >= low) {
                    res.add(b);
                }
                firstDigit++;
            } else {
                firstDigit = 1;
                size++;
                if (size == 10) {
                    return res;
                }
            }
        }
    }

    private int createInt(int firstDigit, int size) {
        int res = 0;
        for (int i = size - 1; i >= 0; i--) {
            res += firstDigit * Math.pow(10, i);
            firstDigit++;
            if (firstDigit == 10) {
                firstDigit = 0;
            }
        }

        return res;
    }
}
