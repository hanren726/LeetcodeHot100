package No152_maxProduct;

/**
 * 动态规划变种
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, -2, 4, -4};
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int preMax = nums[0];
        int preMin = nums[0];
        int res = nums[0];
        int curMax;
        int curMin;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                curMax = Math.max(nums[i], preMax * nums[i]);
                curMin = Math.min(nums[i], preMin * nums[i]);
            } else {
                curMax = Math.max(nums[i], preMin * nums[i]);
                curMin = Math.min(nums[i], preMax * nums[i]);
            }
            res = Math.max(curMax, res);
            preMax = curMax;
            preMin = curMin;
        }
        return res;
    }


    public int max(int[] nums) {
        int len = nums.length;
        int min = nums[0];
        int max = nums[0];
        int res = nums[0];

        for (int i = 1; i < len; i++) {
            int tempMax = max;
            max = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
            min = Math.min(tempMax * nums[i], Math.min(min * nums[i], nums[i]));
            res = Math.max(res, max);
        }
        return res;
    }


}
