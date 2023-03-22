package easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
 * Runtime 58.93% Memory 31.9%
 */
public class SortIntegersByTheNumberOf1Bits {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        arr = new SortIntegersByTheNumberOf1Bits().sortByBits(arr);
        System.out.println(Arrays.toString(arr));
    }

    public int[] sortByBits(int[] arr) {
        List<MyInt> list = new ArrayList<>();
        for (int i : arr) {
            list.add(new MyInt(i));
        }

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i).val;
        }

        return arr;
    }

    class MyInt implements Comparable<MyInt> {
        int val;
        int countOf1Bit;

        public MyInt(int val) {
            this.val = val;
            this.countOf1Bit = getCountOf1Bit(val);
        }

        private int getCountOf1Bit(int val) {
            int res = 0;

            while (val > 0) {
                res += val % 2;
                val /= 2;
            }

            return res;
        }

        @Override
        public int compareTo(MyInt o) {
            return this.countOf1Bit - o.countOf1Bit == 0
                    ? this.val - o.val
                    : this.countOf1Bit - o.countOf1Bit;
        }
    }
}
