package easy.common;

/**
 * https://leetcode.com/problems/water-bottles/
 * Runtime 100% Memory 97.53%
 */
public class WaterBottles {

    public static void main(String[] args) {
        int numBottles = 9;
        int numExchange = 3;
        int res = new WaterBottles().numWaterBottles(numBottles, numExchange);
        System.out.println(res);
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int res = 0;
        byte remainder = 0;
        byte sum;
        while (numBottles != 0) {
            res += numBottles;
            sum = (byte) (numBottles + remainder);
            numBottles = sum / numExchange;
            remainder = (byte)(sum % numExchange);
        }
        return res;
    }
}
