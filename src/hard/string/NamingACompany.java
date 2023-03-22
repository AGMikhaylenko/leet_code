package hard.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/naming-a-company/
 * Runtime 65.57% Memory 34.43%
 */
public class NamingACompany {

    public static void main(String[] args) {
        String[] ideas = {"ca", "ta", "fa", "db", "ab", "fb", "ec", "tc"};
        long res = new NamingACompany().distinctNames(ideas);
        System.out.println(res);
    }

    public long distinctNames(String[] ideas) {
        long res = 0;

        ArrayList<Set<String>> symbols = convertArrayToListOfSuffix(ideas);
        Set<String> current;
        for (int i = 0; i < symbols.size(); i++) {
            current = symbols.get(i);
            for (int j = i + 1; j < symbols.size(); j++) {
                res += 2L * uniqueNumber(new HashSet<>(current), symbols.get(j));
            }
        }
        return res;
    }

    private int uniqueNumber(Set<String> set1, Set<String> set2) {
        int l = set1.size();
        set1.removeAll(set2);
        return set1.size() * (set2.size() - l + set1.size());
    }

    private ArrayList<Set<String>> convertArrayToListOfSuffix(String[] ideas) {
        List<Set<String>> suffixes = Stream.of(ideas)
                .map(
                        MyLine::new
                ).collect(
                        Collectors.groupingBy(
                                MyLine::getFirst
                        )
                )
                .values()
                .stream()
                .map(
                        list -> list.stream().map(
                                        MyLine::getSubstring
                                )
                                .collect(Collectors.toSet())
                ).toList();

        return new ArrayList<>(suffixes);
    }

    private class MyLine {
        Character first;
        String substring;

        public MyLine(String line) {
            first = line.charAt(0);
            substring = line.substring(1);
        }

        public String getSubstring() {
            return substring;
        }

        public Character getFirst() {
            return first;
        }
    }
}
