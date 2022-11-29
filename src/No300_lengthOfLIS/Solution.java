package No300_lengthOfLIS;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,2,3};
        System.out.println(new Solution().lengthOfLIS(nums));
    }
    int res = 1;
    public int lengthOfLIS(int[] nums) {
        backtrace(nums, new ArrayList<>(), 0);
        return res;
    }

    public void backtrace(int[] nums, List<Integer> cur, int start) {

        for (int i = start; i < nums.length; i++) {

            int latest = Integer.MIN_VALUE;
            if (cur.size() >= 1) {
                latest = cur.get(cur.size() - 1);
            }
            if (nums[i] > latest) {
                cur.add(nums[i]);
                res = Math.max(res, cur.size());
                backtrace(nums, cur, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }


    /**
     * 动态规划： dp[i]表示选中nums[i]后，当前最长递增子序列的长度
     * 遍历到第i的元素，默认dp[i]=1
     * 再定义一个指针j，从0遍历到i，找到最大的dp[j]
     * 此时，dp[i]取值就是dp[i] 和 dp[j]+1 中的较大值
     * @param nums
     * @return
     */

    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
