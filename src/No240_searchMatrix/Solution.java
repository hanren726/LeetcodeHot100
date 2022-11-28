package No240_searchMatrix;

public class Solution {
    // 直接查找
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (target == matrix[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // 二分查找
    public boolean searchMatrix2(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int index = searchRow(row, target);
            if (index >= 0) {
                return true;
            }
        }
        return false;
    }

    public int searchRow(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (row[mid] == target) {
                return mid;
            } else if (row[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 右上角至左下角缩小范围
     * 从右上角开始查找，记当前查找元素为 matrix[x][y]
     * 如果等于 target，return true
     * 如果大于 target，因为每列的元素从上到下升序排列，所以当前这一列不会再有可能找到target，应该从 -1 列继续找
     * 如果小于 target，因为每行的元素从左到右升序排列，所以应该从 +1 行继续找，因为是从右上角开始找的，所以
     * @param matrix
     * @param target
     * @return
     */

    public boolean searchMatrix3(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }

}
