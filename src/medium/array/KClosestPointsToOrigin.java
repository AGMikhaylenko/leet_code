package medium.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * Runtime 63.13% Memory 23.88%
 */
public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        List<MyPoint> list = new ArrayList<>();
        for (int[] p : points) {
            list.add(new MyPoint(p[0], p[1]));
        }

        int[][] res = new int[k][2];
        Collections.sort(list);

        for (int i = 0; i < k; i++) {
            MyPoint p = list.get(i);
            res[i][0] = p.x;
            res[i][1] = p.y;
        }
        return res;
    }

    class MyPoint implements Comparable<MyPoint> {
        int x;
        int y;
        double distance;

        public MyPoint(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = Math.sqrt(x * x + y * y);
        }

        @Override
        public int compareTo(MyPoint o) {
            double b = this.distance - o.distance;
            if (b == 0.0) {
                return 0;
            }
            if (b > 0) {
                return 1;
            }
            return -1;
        }
    }
}
