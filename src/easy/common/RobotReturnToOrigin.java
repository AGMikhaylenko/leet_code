package easy.common;

/**
 * https://leetcode.com/problems/robot-return-to-origin/
 * Runtime 97.33% Memory 13.84%
 */
public class RobotReturnToOrigin {

    public boolean judgeCircle(String moves) {

        int x = 0;
        int y = 0;

        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U' -> y++;
                case 'D' -> y--;
                case 'L' -> x--;
                case 'R' -> x++;
                default -> {
                }
            }
        }

        return x == 0 && y == 0;
    }
}
