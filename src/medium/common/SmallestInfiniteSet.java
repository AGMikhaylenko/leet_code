package medium.common;

import java.util.PriorityQueue;

public class SmallestInfiniteSet {

    PriorityQueue<Integer> returned;
    int min = 1;

    public SmallestInfiniteSet() {
        returned = new PriorityQueue<>();
    }

    public int popSmallest() {
        if (!returned.isEmpty()) {
            return returned.poll();
        } else {
            return min++;
        }
    }

    public void addBack(int num) {
        if (num < min && !returned.contains(num)) {
            returned.add(num);
        }
    }
}
