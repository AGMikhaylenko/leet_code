package easy.operation_with_numbers;

/**
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/
 * Runtime 100% Memory 94.57%
 */
public class CheckIfItIsAStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        float k = 0;
        int deltaY = coordinates[1][1] - coordinates[0][1];
        int deltaX = coordinates[1][0] - coordinates[0][0];

        if (deltaX != 0 && deltaY != 0) {
            k = (float) deltaY / deltaX;
        }

        float b = coordinates[0][1] - k * coordinates[0][0];

        for (int i = 2; i < coordinates.length; i++) {
            if(deltaX == 0) {
                if (coordinates[i][0] != coordinates[0][0]) {
                    return false;
                }else{
                    continue;
                }
            }

            if(deltaY == 0) {
                if (coordinates[i][1] != coordinates[0][1]) {
                    return false;
                }else{
                    continue;
                }
            }

            if (coordinates[i][1] != k * coordinates[i][0] + b) {
                return false;
            }
        }

        return true;
    }
}
