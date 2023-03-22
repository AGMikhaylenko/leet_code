package easy.array;

/**
 * https://leetcode.com/problems/best-poker-hand/
 * Runtime 100% Memory 27.57%
 */
public class BestPokerHand {

    public String bestHand(int[] ranks, char[] suits) {
        boolean resCheck = true;
        char charCheck = suits[0];

        for (char c : suits) {
            if (charCheck != c) {
                resCheck = false;
                break;
            }
        }

        if (resCheck) {
            return "Flush";
        }

        int number = 0;
        for (int i = 0; i < ranks.length; i++) {
            number = 1;
            for (int j = i + 1; j < ranks.length; j++) {
                if (ranks[i] == ranks[j]) {
                    number++;
                }
            }
            ranks[i] = number;
        }

        number = Integer.MIN_VALUE;
        for (int r : ranks) {
            if (r > number) {
                number = r;
            }
        }

        if (number > 3) {
            return "Three of a Kind";
        }
        if (number == 2) {
            return "Pair";
        }

        return "High Card";
    }
}
