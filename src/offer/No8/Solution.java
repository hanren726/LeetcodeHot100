package offer.No8;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int target = 7;
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(solution.minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                res = Math.min(res, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return res;
    }
}
