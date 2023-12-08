package medium.common;

import java.util.*;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Runtime 81.21% Memory 17.10%
 */
public class LetterCombinationsOfAPhoneNumber {

    final static Map<Character, List<Character>> buttons;

    static {
        buttons = new HashMap<>();
        buttons.put('2', List.of('a', 'b', 'c'));
        buttons.put('3', List.of('d', 'e', 'f'));
        buttons.put('4', List.of('g', 'h', 'i'));
        buttons.put('5', List.of('j', 'k', 'l'));
        buttons.put('6', List.of('m', 'n', 'o'));
        buttons.put('7', List.of('p', 'r', 'q', 's'));
        buttons.put('8', List.of('t', 'u', 'v'));
        buttons.put('9', List.of('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        List<String> r = new LinkedList<>();

        if (digits.length() == 0) {
            return r;
        }

        List<Character> symbolsFirstButton = buttons.get(digits.charAt(0));
        List<String> inner = digits.length() == 1
                ? new LinkedList<>()
                : letterCombinations(digits.substring(1));

        for (Character c : symbolsFirstButton) {
            if(inner.isEmpty()){
                r.add(String.valueOf(c));
            }
            for (String s : inner) {
                r.add(c + s);
            }
        }

        return r;
    }

}
