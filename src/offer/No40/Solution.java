package offer.No40;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] matrix = new String[]{"1"};
        System.out.println(solution.maximalRectangle(matrix));
    }

    public int maximalRectangle(String[] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length();
        int[][] left = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i].charAt(j) == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j-1]) + 1;
                }
            }
        }

        int ret = 0;

        for (int i=0; i<n; i++) {
            int[] up = new int[m];
            int[] down = new int[m];

            Stack<Integer> stack = new Stack();
            for (int j=0; j<m; j++) {
                while(!stack.isEmpty() && left[stack.peek()][i] >= left[j][i]) {
                    stack.pop();
                }
                up[j] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(j);
            }

            for (int j=m-1; j>=0; j--) {
                while(!stack.isEmpty() && left[stack.peek()][i] >= left[j][i]) {
                    stack.pop();
                }
                down[j] = stack.isEmpty() ? m : stack.peek();
                stack.push(j);
            }

            for (int j=0; j<m; j++) {
                int height = down[j] - up[j] - 1;
                int area = height * left[j][i];
                ret = Math.max(ret, area);
            }
        }

        return ret;
    }
}
