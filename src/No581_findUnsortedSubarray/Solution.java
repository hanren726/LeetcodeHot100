package No581_findUnsortedSubarray;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
        System.out.println(solution.findUnsortedSubarray2(nums));
    }

    public int findUnsortedSubarray(int[] nums) {
        int[] numsSort = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsSort[i] = nums[i];
        }
        Arrays.sort(numsSort);
        int left = 0;
        while (nums[left] == numsSort[left]) {
            left++;
            if (left == nums.length) {
                return 0;
            }
        }
        int right = nums.length - 1;
        while (nums[right] == numsSort[right]) {
            right--;
        }
        return right - left + 1;
    }


    public int findUnsortedSubarray2(int[] nums) {
        int n = nums.length;
        int left = -1;
        int right = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[n - i - 1] > min) {
                left = n - i - 1;
            } else {
                min = nums[n - i - 1];
            }
            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
