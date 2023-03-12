package offer.No91;

public class Solution {

    public static void main(String[] args) {
        int[][] costs = new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        System.out.println(new Solution().minCost(costs));
    }

    public int minCost(int[][] costs) {
        int n = costs.length;

        if (n == 1) {
            return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
        }

        int[][] dp = new int[n+1][3];
        for(int i=0; i<=n; i++) {
            if (i == 0) {
                for(int j=0; j<3; j++) {
                    dp[i][j] = 0;
                }
            } else {
                for(int j=0; j<3; j++) {
                    dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + costs[i - 1][j];
                }
            }
        }
        return Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
    }

}
