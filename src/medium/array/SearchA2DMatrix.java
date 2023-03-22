package medium.array;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 * Runtime 100% Memory 54.43%
 */
public class SearchA2DMatrix {

    public static void main(String[] args) {
        int [][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 60;
        System.out.println(new SearchA2DMatrix().searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (matrix[mid / matrix[0].length][mid % matrix[0].length] == target) {
                return true;
            }

            if (matrix[mid / matrix[0].length][mid % matrix[0].length] < target) {
                left = mid + 1;
            }

            if (matrix[mid / matrix[0].length][mid % matrix[0].length] > target) {
                right = mid -1;
            }
        }

        return false;
    }
}
