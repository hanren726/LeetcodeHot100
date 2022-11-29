package No283_moveZeroes;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0,1,0,3,12};
        solution.moveZeroes2(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void moveZeroes(int[] nums) {
        int size = nums.length;
        int i = 0;
        int right = size - 1;
        while (i < right) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j];
                }
                nums[right] = 0;
                right--;
            } else {
                i++;
            }
        }
    }

    /**
     * 第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
     * 第二次遍历把末尾的元素都赋为0即可
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[j++] = 0;
        }
    }

    /**
     * 一次遍历，参考快排，两个指针，a往后面轮询，b表示待替换的0
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        int a = 0;
        int b = 0;
        while (a < nums.length) {
            if (nums[a] != 0) {
                if (a == b) {
                    b++;
                } else {
                    int temp = nums[a];
                    nums[a] = nums[b];
                    nums[b++] = temp;
                }
            }
            a++;
        }
    }
}
