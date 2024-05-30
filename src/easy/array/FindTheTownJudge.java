package easy.array;

/**
 * https://leetcode.com/problems/find-the-town-judge/
 * Runtime 71.04% Memory 69.91%
 */
public class FindTheTownJudge {

    public int findJudge(int n, int[][] trust) {

        boolean[] hasTrust = new boolean[n];
        int[] countOfTrusted = new int[n];

        for (int[] pair : trust) {
            hasTrust[pair[0] - 1] = true;
            countOfTrusted[pair[1] - 1]++;
        }

        for (int i = 0; i < n; i++) {
            if (!hasTrust[i] && countOfTrusted[i] == n - 1) {
                return i + 1;
            }
        }

        return -1;
    }
}
