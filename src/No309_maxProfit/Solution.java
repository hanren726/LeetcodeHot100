package No309_maxProfit;

/**
 * dp[i][0] : 第 i+1 天不持股的情况下能获得的最大收益
 * dp[i][1] : 第 i+1 天持股的情况下能获得的最大收益
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], ((i - 2 < 0) ? 0 : dp[i - 2][0]) - prices[i]);
        }

        return dp[n - 1][0];
    }

}
