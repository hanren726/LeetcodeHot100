package No416_canPartition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(solution.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;

        return dfs(nums, 0, 0, target);
    }
    private Map<String, Boolean> map = new HashMap<>();
    public boolean dfs(int[] nums, int index, int sum, int target) {
        if (nums.length == index) {
            if (sum == target) {
                return true;
            } else {
                return false;
            }
        }
        String key = sum + "&" + index;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        boolean with = dfs(nums, index + 1, sum + nums[index], target);
        boolean without = dfs(nums, index + 1, sum, target);
        boolean ret = with || without;
        map.put(key, ret);
        return ret;
    }



    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        int len = nums.length;

        //状态：dp[m][n]表示背包容量为 m，有前 n 个物品（ [0, n-1]共n个 ）时能否装满背包
        boolean[][] dp = new boolean[target + 1][len + 1];
        for (int i = 0; i <= len; i++) {
            dp[0][i] = true;
        }

        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= len; j++) {
                if (i < nums[j - 1]) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] || dp[i - nums[j - 1]][j - 1];
                }
            }
        }

        return dp[target][len];
    }
}
