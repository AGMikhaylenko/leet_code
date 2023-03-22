package easy.operation_with_numbers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/contest/biweekly-contest-99/problems/split-with-minimum-sum/
 */
public class SplitWithMinimumSum {

    public static void main(String[] args) {
        System.out.println(new SplitWithMinimumSum().splitNum(6807));
    }

    public int splitNum(int num) {
        List<Integer> digits = new ArrayList<>(String.valueOf(num).length());

        while (num != 0) {
            digits.add(num % 10);
            num /= 10;
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        boolean isFirst = true;
        int min;

        while (!digits.isEmpty()) {
            min = digits.stream().min(Comparator.naturalOrder()).get();
            digits.remove(Integer.valueOf(min));

            if (isFirst) {
                sb1.append(String.valueOf(min));
            } else {
                sb2.append(String.valueOf(min));
            }
            isFirst = !isFirst;
        }

        return Integer.valueOf(sb1.toString()) + Integer.valueOf(sb2.toString());
    }
}
