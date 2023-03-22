package easy.array;

/**
 * https://leetcode.com/problems/can-place-flowers/
 * Runtime 100% Memory 10.7%
 */
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (short i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 0) {
                if (i == 0 && (flowerbed.length == 1 || flowerbed[i + 1] == 0)
                        || i == flowerbed.length - 1 && flowerbed[i - 1] == 0
                        || i != 0 && flowerbed[i - 1] == 0 && i != flowerbed.length - 1 && flowerbed[i + 1] == 0) {
                    n--;
                    i++;
                }
            } else {
                i++;
            }
        }

        return n == 0;
    }
}
