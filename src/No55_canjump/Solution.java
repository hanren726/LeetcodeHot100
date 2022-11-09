package No55_canjump;

/**
 * k 表示当前最远能到的距离
 * 从0开始遍历，每次动态更新k，如果发现k的大小>=n-1，说明可以到达了，直接return true
 */
public class Solution {

    public boolean canJump(int[] nums) {
        int n = nums.length;

        int k = 0;
        for (int i = 0; i <= k; i++) {
            int temp = nums[i] + i;
            k = Math.max(k, temp);
            if (k >= n - 1) {
                return true;
            }
        }
        return false;
    }
}
