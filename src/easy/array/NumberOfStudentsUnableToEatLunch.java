package easy.array;

/**
 * https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
 * Runtime 100% Memory 72.89%
 */
public class NumberOfStudentsUnableToEatLunch {

    public int countStudents(int[] students, int[] sandwiches) {
        int stSquare = 0;
        int stCircular = 0;

        for (int i : students) {
            if (i == 1) {
                stSquare++;
            } else {
                stCircular++;
            }
        }

        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 0 && stCircular > 0) {
                stCircular--;
            } else {
                if (sandwiches[i] == 1 && stSquare > 0) {
                    stSquare--;
                } else {
                    break;
                }
            }
        }
        return stCircular + stSquare;
    }
}
