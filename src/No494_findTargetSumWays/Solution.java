package No494_findTargetSumWays;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution.findTargetSumWays(nums, target));

    }
    int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);

        return res;
    }

    public void backtrack(int[] nums,  int target, int index, int curSum) {
        if (index == nums.length) {
            if (curSum == target) {
                res++;
            }
        } else {
            curSum += nums[index]; //选择+

            backtrack(nums, target, index + 1, curSum);

            curSum -= nums[index]; //撤掉选择+

            curSum -= nums[index]; //选择-

            backtrack(nums, target, index + 1, curSum);

            curSum += nums[index]; //撤销选择-
        }
    }
}
