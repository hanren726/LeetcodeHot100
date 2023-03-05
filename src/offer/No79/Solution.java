package offer.No79;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> res = solution.subsets(nums);
        for (List<Integer> el : res) {
            for (Integer i : el) {
                System.out.printf(i+",");
            }
            System.out.println("=====");
        }
    }


    public List<List<Integer>> subsets(int[] nums) {
        backtrace(nums, 0);
        return res;
    }

    public void backtrace(int[] nums, int start) {
        res.add(new ArrayList<>(cur));
        for(int i=start; i<nums.length; i++) {
            cur.add(nums[i]);
            backtrace(nums, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
