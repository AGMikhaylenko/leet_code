package medium.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/task-scheduler/
 * Not solved!
 */
public class TaskScheduler {

    public static void main(String[] args) {
        String[] task = {"A", "A", "A", "A", "A", "A", "B", "C", "D", "E", "F", "G"};
        char[] tasks = new char[task.length];
        for (int i = 0; i < task.length; i++) {
            tasks[i] = task[i].charAt(0);
        }
        int n = 2;
        System.out.println(new TaskScheduler().leastInterval(tasks, n));
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            if (map.containsKey(c)) {
                map.merge(c, 1, Integer::sum);
            } else {
                map.put(c, 1);
            }
        }

        int res = 0;
        int prevSize = n + 1;

        while (!map.isEmpty()) {
            res += n + 1 - prevSize;

            if (map.size() <= n) {
                prevSize = map.size();
            }

            res += map.size();

            Set<Character> set = Set.copyOf(map.keySet());
            for (char c : set) {
                if (map.get(c) == 1) {
                    map.remove(c);
                } else {
                    map.merge(c, -1, Integer::sum);
                }
            }
        }

        return res;
    }
}
