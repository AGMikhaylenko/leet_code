package easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Easy
 * https://leetcode.com/problems/last-stone-weight/description/
 * Runtime 33.76% Memory 95.17%
 */
public class LastStoneWeight {

    public static void main(String[] args) {
        int[] stones = {7, 6, 7, 6, 9};
        int res = new LastStoneWeight().lastStoneWeight(stones);
        System.out.println(res);
    }

    public int lastStoneWeight(int[] stones) {
        List<Integer> queue = new ArrayList<>();

        for (int i : stones) {
            queue.add(i);
        }

        queue.sort(Comparator.reverseOrder());

        int a;
        int b;
        int res;
        while (queue.size() > 1) {
            System.out.println(queue);
            a = queue.remove(0);
            b = queue.remove(0);
            res = Math.abs(a - b);

            if (res != 0) {
                if (queue.isEmpty()) {
                    queue.add(res);
                } else {
                    for (int i = queue.size() - 1; i >= 0; i--) {
                        if (res < queue.get(i)) {
                            if (i == queue.size() - 1) {
                                queue.add(res);
                            } else {
                                queue.add(i + 1, res);
                            }
                            break;
                        }
                        if (i == 0) {
                            queue.add(i + 1, res);
                        }
                    }
                }
            }
        }

        return queue.isEmpty() ? 0 : queue.get(0);
    }
}
