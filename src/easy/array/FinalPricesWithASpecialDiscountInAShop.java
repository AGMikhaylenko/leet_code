package easy.array;

/**
 * https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
 * Runtime 98.95% Memory 93.55%
 */
public class FinalPricesWithASpecialDiscountInAShop {

    public static void main(String[] args) {

    }

    public int[] finalPrices(int[] prices) {
        int discount;
        for (short i = 0; i < prices.length - 1; i++) {
            discount = 0;
            for (int j = i + 1; j < prices.length && discount == 0; j++) {
                if (prices[j] <= prices[i]) {
                    discount = prices[j];
                }
            }
            prices[i] -= discount;
        }
        return prices;
    }
}
