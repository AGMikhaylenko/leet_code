package easy.array;

/**
 * https://leetcode.com/problems/find-the-highest-altitude/
 */
public class FindTheHighestAltitude {

    public int largestAltitude(int[] gain) {
        int max = 0;
        int curr = 0;

        for (int i = 0; i < gain.length; i++) {
            curr += gain[i];
            if (curr > max) {
                max = curr;
            }
        }

        return max;
    }
}
