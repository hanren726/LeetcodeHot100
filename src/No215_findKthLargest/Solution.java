package No215_findKthLargest;

/**
 * 快速排序变种 - 快速选择排序
 * 因为要求时间复杂度 0(n)
 * 改进快速排序算法来解决这个问题：在分解的过程当中，我们会对子数组进行划分，
 * 如果划分得到的 q 正好就是我们需要的下标，就直接返回 a[q]；
 * 否则，如果 q 比目标下标小，就递归右子区间，否则递归左子区间。
 * 这样就可以把原来递归两个区间变成只递归一个区间，提高了时间效率。这就是「快速选择」算法。
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        System.out.println(solution.findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length-1, k);
    }

    int quickSort(int[] nums, int low, int high, int k) {
        if (low > high) return 0;
        int i = low;
        int j = high;
        int temp = nums[low];
        while(i<j) {
            // 一定要找到比基准值小的，所以 =temp的，也要移动指针
            while(i<j && nums[j] >= temp) {
                j--;
            }
            while(i<j && nums[i] <= temp) {
                i++;
            }
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        //调换i和基准位的值
        nums[low] = nums[i];
        nums[i] = temp;
        if (i == nums.length - k) {
            return nums[i];
        } else if (i < nums.length - k) {
            return quickSort(nums, i+1, high, k);
        } else {
            return quickSort(nums, low, i-1, k);
        }
    }
}
