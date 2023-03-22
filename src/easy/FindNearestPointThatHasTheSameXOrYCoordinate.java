package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
 * Runtime 70.16% Memory 40.87%
 */
public class FindNearestPointThatHasTheSameXOrYCoordinate {

    public static void main(String[] args) {

    }

    public int nearestValidPoint(int x, int y, int[][] points) {
        List<MyPoint> validPoints = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                validPoints.add(
                        new MyPoint(
                                i,
                                points[i][0],
                                points[i][1],
                                Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y)
                        )
                );
            }
        }

        if (validPoints.isEmpty()) {
            return -1;
        } else {
            return Collections.min(validPoints).index;
        }
    }

    class MyPoint implements Comparable<MyPoint> {
        int index;
        int x;
        int y;
        double distance;

        public MyPoint(int index, int x, int y, double distance) {
            this.index = index;
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(MyPoint o) {
            return this.distance - o.distance == 0.0
                    ? this.x - o.x + this.y - o.y
                    : this.distance - o.distance > 0.0 ? 1 : -1;
        }
    }
}
