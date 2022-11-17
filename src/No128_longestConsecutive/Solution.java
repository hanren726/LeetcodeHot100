package No128_longestConsecutive;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 2};
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive2(nums));
    }

    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int left = 0;
        int right = 1;
        int res = 1;
        int curRes = 1;
        while (left < nums.length && right < nums.length) {
            if (nums[right] - nums[right - 1] == 0) {
                right++;
            } else if (nums[right] - nums[right - 1] == 1) {
                right++;
                curRes++;
                res = Math.max(res, curRes);
            } else {
                curRes = 1;
                left = right;
                right = left + 1;
            }
        }
        return res;
    }


    public int longestConsecutive2(int[] nums) {
        //去重考虑用set
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : set) {
            int cur = num;
            // 比如最终结果是 2 3 4 5，那么最终结果一定要从2开始，从3 4 5开始没有意义，所以条件就是 cur-1 不在set里
            if (!set.contains(cur - 1)) {
                while (set.contains(cur + 1)) {
                    cur++;
                }
            }
            ans = Math.max(ans, cur - num + 1);
        }
        return ans;
    }
}
