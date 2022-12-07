package No448_findDisappearedNumbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(solution.findDisappearedNumbers2(nums));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] candi = new boolean[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            candi[nums[i]] = true;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < candi.length; i++) {
            if (!candi[i]) {
                res.add(i);
            }
        }
        return res;
    }


    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        for (int num : nums) {
            nums[(num - 1) % len] += len;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] <= len) {
                res.add(i+1);
            }
        }
        return res;
    }
}
