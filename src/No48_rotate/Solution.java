package No48_rotate;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 旋转 90 度: A[x][y] = A[y][n-1-x]
 *
 * 如何原地实现旋转呢，可以通过翻转实现
 * 先通过水平轴翻转： A[x][y] = A[n - 1 - x][y]
 * 再通过对角线翻转： A[n - 1 - x][y] = A[y][n - 1 - x]
 *
 * 是不是可以得到 A[x][y] = A[y][n - 1 - x]
 *
 */
public class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
