package No198_rob;

public class Solution {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    /**
     * 空间优化：计算最后一个 dp[n]的时候，只用到了dp[n-1]、dp[n-2]
     * 思路：用两个变量记录这两个值，并持续更新
     * 优化dp数组，
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int pre = nums[0];
        int cur = Math.max(nums[0], nums[1]);
        int res = 0;
        for (int i = 2; i < nums.length; i++) {
            res = Math.max(nums[i] + pre, cur);
            pre = cur;
            cur = res;
        }
        return res;
    }



}
