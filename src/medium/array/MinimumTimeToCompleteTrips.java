package medium.array;

/**
 * https://leetcode.com/problems/minimum-time-to-complete-trips/
 */
public class MinimumTimeToCompleteTrips {

    public long minimumTime(int[] time, int totalTrips) {
        int[] trips = new int[time.length];

        int count = 0;
        int i = 0;

        while (count < totalTrips) {

            for (int j = 0; j < time.length; j++) {
                trips[j]++;
                if (trips[j] == time[j]) {
                    count++;
                    trips[j] = 0;
                }
            }

            i++;
        }

        return i;
    }
}
