package easy.common;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/path-crossing/
 * Runtime 97.58% Memory 70.22%
 */
public class PathCrossing {

    public boolean isPathCrossing(String path) {
        Set<Point> visited = new HashSet<>();
        Point last = new Point(0, 0);
        visited.add(last);

        for (char c : path.toCharArray()) {
            switch (c) {
                case 'N' -> last = new Point(last.x, last.y + 1);
                case 'S' -> last = new Point(last.x, last.y - 1);
                case 'W' -> last = new Point(last.x - 1, last.y);
                case 'E' -> last = new Point(last.x + 1, last.y);
            }

            if (visited.contains(last)) {
                return true;
            } else {
                visited.add(last);
            }
        }

        return false;
    }
}
