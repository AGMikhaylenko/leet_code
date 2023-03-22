package easy.array;

/**
 * https://leetcode.com/problems/richest-customer-wealth/
 * Runtime 100% Memory 89%
 */
public class RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {
        byte i = 0;

        for (; i < accounts.length; i++) {
            for (byte j = (byte) (accounts[i].length - 2); j >= 0; j--) {
                accounts[i][j] += accounts[i][j + 1];
            }
            if (i != 0 && accounts[i][0] < accounts[i - 1][0]) {
                accounts[i][0] = accounts[i - 1][0];
            }
        }

        return accounts[i - 1][0];
    }
}
