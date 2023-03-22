package easy.array;

/**
 * https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/
 * Runtime 100% Memory 55.86%
 */
public class DetermineWhetherMatrixCanBeObtainedByRotation {

    public boolean findRotation(int[][] mat, int[][] target) {
        boolean r0 = true;
        boolean r90 = true;
        boolean r180 = true;
        boolean r270 = true;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (r0 && mat[i][j] != target[i][j]) {
                    r0 = false;
                }
                if (r90 && mat[i][j] != target[j][mat.length - 1 - i]) {
                    r90 = false;
                }
                if (r180 && mat[i][j] != target[mat.length - 1 - i][mat.length - 1 - j]) {
                    r180 = false;
                }
                if (r270 && mat[i][j] != target[mat.length - 1 - j][i]) {
                    r270 = false;
                }

                if (!(r0 || r90 || r180 || r270)) {
                    return false;
                }
            }
        }

        return true;
    }
}
