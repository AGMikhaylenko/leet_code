package medium.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Medium
 * https://leetcode.com/problems/bulls-and-cows
 */
public class BullsAndCows {

    public static void main(String[] args) {
        String secret = "0123";
        String guess = "1111";

        System.out.println(new BullsAndCows().getHint(secret, guess));
    }

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        Map<Character, ArrayList<Integer>> indexesByDigitsMap = new HashMap<>();
        char[] secretSymbols = secret.toCharArray();
        for (int i = 0; i < secretSymbols.length; i++) {
            if (indexesByDigitsMap.containsKey(secretSymbols[i])) {
                indexesByDigitsMap.get(secretSymbols[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                indexesByDigitsMap.put(secretSymbols[i], list);
            }
        }

        char[] guessSymbols = guess.toCharArray();
        for (int i = 0; i < guessSymbols.length; i++) {
            ArrayList<Integer> indexes = indexesByDigitsMap.get(guessSymbols[i]);

            if (indexes != null && indexes.contains(i)) {
                guessSymbols[i] = 'n';
                indexes.remove(new Integer(i));
                bulls++;
            }
        }

        for (int i = 0; i < guessSymbols.length; i++) {
            if (guessSymbols[i] != 'n') {

                List<Integer> indexes = indexesByDigitsMap.get(guessSymbols[i]);

                if (indexes != null && !indexes.isEmpty()) {
                    indexes.remove(0);
                    cows++;
                }
            }
        }

        return String.format("%dA%dB", bulls, cows);
    }
}
