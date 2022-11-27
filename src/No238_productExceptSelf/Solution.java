package No238_productExceptSelf;

public class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] L = new int[nums.length];
        int[] R = new int[nums.length];

        L[1] = 1;
        R[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            L[i] = nums[i-1] * L[i - 1];
        }
        for (int i = nums.length - 2; i >= 0 ; i--) {
            R[i] = nums[i+1] * R[i + 1];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = L[i] * R[i];
        }
        return ans;
    }

    /**
     * 空间复杂度O(1)
     * 记录L的数组用结果数组
     * 右侧元素的乘积用R临时记录一下
     * @param nums
     * @return
     */
    public int[] productExceptSelf2(int[] nums) {

        int[] ans = new int[nums.length];

        ans[1] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = nums[i-1] * ans[i - 1];
        }

        //R表示右侧所有元素的乘积
        int R = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * R;
            R += nums[i];
        }
        return ans;
    }
}
