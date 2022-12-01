package No322_coinChange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = new int[]{3,7,405,436};
        System.out.println(solution.coinChange(coins, 883));
    }

    /**
     * 显然回溯会导致超时
     */
    int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        backtrack(coins, new ArrayList<>(), amount, 0);
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public void backtrack(int[] coins, List<Integer> cur, int amount, int start) {
        if (cur.size() > res) {
            return;
        }
        if (sum(cur) == amount) {
            res = Math.min(res, cur.size());
            return;
        }
        if (sum(cur) > amount) {
            return;
        }
        for (int i = coins.length - 1; i >= 0; i--) {
            cur.add(coins[i]);
            backtrack(coins, cur, amount, i);
            cur.remove(cur.size() - 1);
        }
    }

    public int sum(List<Integer> cur) {
        int sum = 0;
        for (Integer coin : cur) {
            sum += coin;
        }
        return sum;
    }


    /**
     * 采用动态规划
     *
     * dp[i] 表示 总额为 i 时，需要最少的硬币数
     * coins[j]是第j枚硬币的金额，需要从 dp[i-coins[j]] 转移过来，数量再加1
     * 子问题是： dp[i - coins[j] + 1
     */
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[coins.length + 1];
        int max = amount + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
