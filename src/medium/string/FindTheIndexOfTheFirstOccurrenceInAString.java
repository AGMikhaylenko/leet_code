package medium.string;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 * Runtime 8.33% Memory 5.45%
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {

    public int strStr(String haystack, String needle) {
        char[] symbolsStack = haystack.toCharArray();
        char[] symbolsNeedle = needle.toCharArray();
        Set<Integer> indexes = new HashSet<>();
        Set<Integer> buf = new HashSet<>();

        for (int i = 0; i < symbolsStack.length; i++) {
            if (symbolsStack[i] == symbolsNeedle[0]) {
                indexes.add(0);
            }
            buf.clear();
            for (Integer index : indexes) {
                if (symbolsStack[i] == symbolsNeedle[index]) {
                    if (index == symbolsNeedle.length - 1) {
                        return i - index;
                    } else {
                        buf.add(index + 1);
                    }
                }
            }
            indexes = new HashSet<>(buf);
        }

        return -1;
    }
}
