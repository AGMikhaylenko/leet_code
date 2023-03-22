package medium.string;

import java.util.ArrayList;
import java.util.List;

/**
 *  https://leetcode.com/problems/basic-calculator-ii/
 *  Runtime 62.97% Memory 20.26%
 */
public class BasicCalculator2 {

    public static void main(String[] args) {
        String s = " 5 / 2 ";
        System.out.println(new BasicCalculator2().calculate(s));
    }

    public int calculate(String s) {
        List<Integer> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if (s.charAt(i) == '/'
                    || s.charAt(i) == '*'
                    || s.charAt(i) == '+'
                    || s.charAt(i) == '-') {
                operators.add(s.charAt(i));
            } else {
                sb.setLength(0);
                sb.append(s.charAt(i));
                while (i != s.length() - 1
                        && s.charAt(i + 1) != '/'
                        && s.charAt(i + 1) != '*'
                        && s.charAt(i + 1) != '+'
                        && s.charAt(i + 1) != '-'
                        && s.charAt(i + 1) != ' ') {
                    sb.append(s.charAt(++i));
                }
                numbers.add(Integer.valueOf(sb.toString()));
            }
        }

        int shift = 0;
        int res;

        List<Integer> indexesForRemove = new ArrayList<>();
        if (operators.contains('*') || operators.contains('/')) {
            for (int i = 0; i < operators.size(); i++) {
                if (operators.get(i) == '*' || operators.get(i) == '/') {
                    if (operators.get(i) == '*') {
                        res = numbers.get(i - shift) * numbers.get(i - shift + 1);
                    } else {
                        res = numbers.get(i - shift) / numbers.get(i - shift + 1);
                    }
                    numbers.remove(i - shift);
                    numbers.remove(i - shift);
                    numbers.add(i - shift, res);
                    indexesForRemove.add(i);
                    shift++;
                }
            }
            for (int i = indexesForRemove.size() - 1; i >= 0; i--) {
                operators.remove(indexesForRemove.get(i).intValue());
            }
        }

        int value = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == '+') {
                value += numbers.get(i + 1);
            } else {
                value -= numbers.get(i + 1);
            }
        }

        return value;
    }
}
