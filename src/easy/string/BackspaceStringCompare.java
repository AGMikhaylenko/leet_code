package easy.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Easy
 * https://leetcode.com/problems/backspace-string-compare
 */
public class BackspaceStringCompare {

    public static void main(String[] args) {
        String s = "ab##";
        String t = "##c#dd#";
        System.out.println(new BackspaceStringCompare().backspaceCompare(s, t));
    }

    public boolean backspaceCompare(String s, String t) {
        List<Character> symbolsS = new ArrayList<>();
        List<Character> symbolsT = new ArrayList<>();

        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        for (int i = 0; i < charS.length; i++) {
            if (charS[i] == '#') {
                if (!symbolsS.isEmpty()) {
                    symbolsS.remove(symbolsS.size() - 1);
                }
            } else {
                symbolsS.add(charS[i]);
            }
        }

        for (int i = 0; i < charT.length; i++) {
            if (charT[i] == '#') {
                if (!symbolsT.isEmpty()) {
                    symbolsT.remove(symbolsT.size() - 1);
                }
            } else {
                symbolsT.add(charT[i]);
            }
        }

        return Objects.equals(symbolsS, symbolsT);
    }
}
