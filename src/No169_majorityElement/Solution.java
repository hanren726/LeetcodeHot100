package No169_majorityElement;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 3, 2, 4, 3};
        System.out.println(solution.majorityElement2(nums));
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            int newCount = count + 1;
            map.put(num, newCount);
            if (newCount > nums.length / 2) {
                return num;
            }
        }
        return 0;
    }

    /**
     * 摩尔投票
     *
     * 多数：大于一半的数
     * 从第一个开始遍历，标记为候选人，count记为1，遇到和候选人相等，count就加1，否则就减1
     * 如果count减到0，那么说明这个候选人没有机会了，替换成当前元素，count重新记为1
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int candi = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candi) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candi = nums[i];
                    count = 1;
                }
            }
        }
        return candi;
    }
}
