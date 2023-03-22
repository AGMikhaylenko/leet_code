package medium.array;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/seat-reservation-manager/
 * Runtime 27.75% Memory 53.37%
 */

public class SeatReservationManager {

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public SeatReservationManager(int n) {
        for (int i = 1; i <= n; i++) {
            pq.add(i);
        }
    }

    public int reserve() {
        return pq.poll();
    }

    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}
