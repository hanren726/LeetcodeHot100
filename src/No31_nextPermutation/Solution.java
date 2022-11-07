package No31_nextPermutation;

public class Solution {

    /**
     * 从后向前查找第一个非降序的数 a[i]
     * 从后向前查找第一个比a[i]大的数 a[j]
     * 交换a[i] a[j]
     * 反转 a[i]后面的所有元素
     *
     * eg：1 5 8 4 7 6 5 3 1
     * a[i]:  4
     * a[j]:  倒数第三位：5
     * 交换后：1 5 8 5 7 6 4 3 1
     * 反转后：1 5 8 5 1 3 4 6 7
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            //交换两者
            swap(nums, i, j);
        }
        //重新排序i以后的
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int index) {
        int left = index;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
