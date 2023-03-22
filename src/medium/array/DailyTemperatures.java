package medium.array;

/**
 * https://leetcode.com/problems/daily-temperatures/
 * Runtime 97.63% Memory 32.51%
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        int step;
        for (int i = temperatures.length - 2; i >= 0; i--) {
            step = 1;
            while (true) {
                if (temperatures[i] < temperatures[i + step]) {
                    answer[i] = step;
                    break;
                } else {
                    if (answer[i + step] == 0) {
                        break;
                    } else {
                        step += answer[i + step];
                    }
                }
            }
        }
        return answer;
    }
}
