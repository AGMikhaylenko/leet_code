package medium.operations_with_numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/multiply-strings/
 * Runtime 8.94% Memory 14.82%
 */
public class MultiplyStrings {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        var res = new MultiplyStrings().multiply(num1, num2);
        System.out.println(res);
    }

    public String multiply(String num1, String num2) {
        Integer[] digits1 = num1.chars().mapToObj(c -> (char) c)
                .map(String::valueOf)
                .map(Integer::valueOf)
                .toArray(Integer[]::new);

        Integer[] digits2 = num2.chars().mapToObj(c -> (char) c)
                .map(String::valueOf)
                .map(Integer::valueOf)
                .toArray(Integer[]::new);

        StringBuilder sb = new StringBuilder();

        List<String> numbers = new ArrayList<>();
        byte added;
        byte res;
        int i;
        for (short n2 = (short) (digits2.length - 1); n2 >= 0; n2--) {
            sb.setLength(0);
            added = 0;
            for (short n1 = (short) (digits1.length - 1); n1 >= 0; n1--) {
                res = (byte) (digits2[n2] * digits1[n1]);
                sb.append((res + added) % 10);
                added = (byte) ((res + added) / 10);
            }

            if (added != 0) {
                sb.append(added);
            }

            sb.reverse();
            for (i = 0; i < digits2.length - 1 - n2; i++) {
                sb.append('0');
            }
            numbers.add(sb.toString());
        }

        return addedStrings(numbers, sb);
    }

    private String addedStrings(List<String> numbers, StringBuilder sb) {
        sb.setLength(0);

        List<Integer[]> nums = numbers
                .stream()
                .map(num -> num.chars().mapToObj(c -> (char) c)
                        .map(String::valueOf)
                        .map(Integer::valueOf)
                        .toArray(Integer[]::new)

                )
                .toList();

        int res;
        int added = 0;
        int i = 0;
        boolean isBreak = false;

        while (!isBreak) {
            isBreak = true;
            res = 0;
            for (Integer[] digits : nums) {
                if (digits.length - 1 - i >= 0) {
                    res += digits[digits.length - 1 - i];
                    if (isBreak) {
                        isBreak = false;
                    }
                }
            }
            res += added;
            sb.append((res) % 10);
            added = res / 10;
            i++;
            if(isBreak && added>0){
                isBreak = false;
            }
        }

        removeFirstNils(sb.reverse());
        return sb.toString();
    }

    private void removeFirstNils(StringBuilder stringBuilder) {
        while (stringBuilder.charAt(0) == '0' && stringBuilder.length() > 1) {
            stringBuilder.deleteCharAt(0);
        }
    }
}
