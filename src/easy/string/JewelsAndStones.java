package easy.string;

/**
 * https://leetcode.com/problems/jewels-and-stones/
 */
public class JewelsAndStones {

    public int numJewelsInStones(String jewels, String stones) {
        char[] j = jewels.toCharArray();
        char[] s = stones.toCharArray();

        int n = 0;
        for (char jj : j) {
            for (char sy : s) {
                if (jj == sy) {
                    n++;
                }
            }
        }

        return n;
    }
}
