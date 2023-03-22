package easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/add-to-array-form-of-integer/
 * Runtime 12.84% Memory 55.33%
 */
public class AddToArrayFormOfInteger {

    public static void main(String[] args) {
        int[] num = {2, 1, 5};
        int k = 806;
        System.out.println(new AddToArrayFormOfInteger().addToArrayForm(num, k));
    }

    public List<Integer> addToArrayForm(int[] num, int k) {
        int added = 0;
        List<Integer> res = new ArrayList<>();
        int buf = 0;

        int index = num.length - 1;
        while (index >= 0 || k != 0 || added != 0) {
            buf = k % 10 + added;
            if (index >= 0) {
                buf += num[index];
            }
            res.add(0, buf % 10);
            added = buf / 10;

            index--;
            k /= 10;
        }

        return res;
    }
}
