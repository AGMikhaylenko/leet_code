package medium.common;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/my-calendar-i/
 * Runtime 28.88% Memory 47.22%
 */
public class MyCalendarI {

    final List<FreeTime> freeIntervals;

    public MyCalendarI() {
        this.freeIntervals = new ArrayList<>();
        freeIntervals.add(new FreeTime(0, Integer.MAX_VALUE));
    }

    public boolean book(int start, int end) {
        FreeTime timeForAdd = null;
        for (FreeTime freeTime : freeIntervals) {
            if (freeTime.start <= start && freeTime.end >= end) {
                timeForAdd = freeTime;
                break;
            }
        }
        if (timeForAdd == null) {
            return false;
        }

        freeIntervals.remove(timeForAdd);
        if (timeForAdd.start != start) {
            freeIntervals.add(new FreeTime(timeForAdd.start, start));
        }
        if (timeForAdd.end != end) {
            freeIntervals.add(new FreeTime(end, timeForAdd.end));
        }

        return true;
    }

    class FreeTime {
        int start;
        int end;

        public FreeTime(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
