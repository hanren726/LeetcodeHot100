package No34_searchRange;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 看到 O(log n) ，请下意识使用二分法
 */
public class Solution {

    public static void main(String[] args) {
//        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] nums = new int[]{2,2};
        int target = 2;
        int[] res = searchRange(nums, target);
        for (int re : res) {
            System.out.println(re);
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            int index = nums[0] == target ? 0 : -1;
            return new int[]{index, index};
        }
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int[] res = new int[]{-1, -1};
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                int i = mid;
                int j = mid;
                while (i > 0 && nums[i-1] == target) {
                    i--;
                }
                while (j < n - 1 && nums[j+1] == target) {
                    j++;
                }
                res[0] = i;
                res[1] = j;
                return res;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
