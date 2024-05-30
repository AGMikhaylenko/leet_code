package easy.array;

/**
 * https://leetcode.com/problems/time-needed-to-buy-tickets/
 * Runtime 100% Memory 86.99%
 */
public class TimeNeededToBuyTickets {

    public int timeRequiredToBuy(int[] tickets, int k) {
        int res = 0;

        for (int i = 0; i < tickets.length; i++) {
            res += Math.min(tickets[i], tickets[k]);
            if (i > k && tickets[i] >= tickets[k]) {
                res--;
            }
        }

        return res;
    }
}
